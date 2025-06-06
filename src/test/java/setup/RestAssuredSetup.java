package setup;

import hooks.Auth;
import io.restassured.RestAssured;
import io.restassured.authentication.OAuthSignature;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import utils.ConfigLoader;

public class RestAssuredSetup {
    RequestSpecBuilder requestSpecBuilder;

    public void restSetup(Auth authType){
         requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://www.quickpickdeal.com/")
                .setBasePath("api")
                .setAccept(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter());
         authorizationSetup(authType);

         RestAssured.requestSpecification = requestSpecBuilder.build();

         RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectResponseTime(Matchers.lessThan(3000L))
                .build();
    }

    private void authorizationSetup(Auth authType) {
        switch (authType) {
            case BASIC:
                requestSpecBuilder.setAuth(RestAssured.basic(
                        ConfigLoader.getBasicUsername(),
                        ConfigLoader.getBasicPassword()));
                break;
            case DIGEST:
                requestSpecBuilder.setAuth(RestAssured.digest(
                        ConfigLoader.getDigestUsername(),
                        ConfigLoader.getDigestPassword()));
                break;
            case BEARER:
                requestSpecBuilder.addHeader("Authorization",
                        "Bearer " + ConfigLoader.getBearerToken());
                break;
            case APIKEY:
                requestSpecBuilder.addQueryParam("api_key", ConfigLoader.getApiKey());
                // Alternatively, use header: .addHeader("X-Api-Key", ConfigLoader.getApiKey());
                break;
            case OAUTH1:
                requestSpecBuilder.setAuth(RestAssured.oauth(
                        ConfigLoader.getOAuth1ConsumerKey(),
                        ConfigLoader.getOAuth1ConsumerSecret(),
                        ConfigLoader.getOAuth1AccessToken(),
                        ConfigLoader.getOAuth1TokenSecret(),
                        OAuthSignature.HEADER));
                break;
            case OAUTH2:
                String accessToken = fetchOAuth2Token();
                requestSpecBuilder.addHeader("Authorization", "Bearer " + accessToken);
                break;
            case P12:
                requestSpecBuilder.setKeyStore(ConfigLoader.getP12FilePath(), ConfigLoader.getP12FilePassword());
            case NONE:
            default:
                break;
        }
    }

    private String fetchOAuth2Token() {
        return RestAssured.given().baseUri(ConfigLoader.getOAuth2TokenUrl())
//                .contentType(ContentType.JSON)
//                .formParam("grant_type", ConfigLoader.getOAuth2GrantType())
//                .formParam("client_id", ConfigLoader.getOAuth2ClientId())
//                .formParam("client_secret", ConfigLoader.getOAuth2ClientSecret())
//                .formParam("scope", ConfigLoader.getOAuth2Scope())
                .get()
                .then()
                .extract()
                .path("Data.Token");
    }
}
