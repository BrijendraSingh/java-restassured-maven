package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigLoader {
    private static Config config;

    public static void loadConfig(String env) {
        config = ConfigFactory.load("environments").getConfig(env);
    }

    public static String getBaseUrl() {
        return config.getString("baseUrl");
    }

    // Basic Auth
    public static String getBasicUsername() {
        return config.getString("api.basic.username");
    }

    public static String getBasicPassword() {
        return config.getString("api.basic.password");
    }

    // Digest Auth
    public static String getDigestUsername() {
        return config.getString("api.digest.username");
    }

    public static String getDigestPassword() {
        return config.getString("api.digest.password");
    }

    // Bearer Token
    public static String getBearerToken() {
        return config.getString("api.bearerToken");
    }

    // API Key
    public static String getApiKey() {
        return config.getString("api.apiKey");
    }

    public static String getP12FilePath(){
        return config.getString("api.clientCert.p12FilePath");
    }

    public static String getP12FilePassword(){
        return config.getString("api.clientCert.p12FilePassword");
    }

    // OAuth 1.0
    public static String getOAuth1ConsumerKey() {
        return config.getString("api.oauth1.consumerKey");
    }

    public static String getOAuth1ConsumerSecret() {
        return config.getString("api.oauth1.consumerSecret");
    }

    public static String getOAuth1AccessToken() {
        return config.getString("api.oauth1.accessToken");
    }

    public static String getOAuth1TokenSecret() {
        return config.getString("api.oauth1.tokenSecret");
    }

    // OAuth 2.0
    public static String getOAuth2ClientId() {
        return config.getString("api.oauth2.clientId");
    }

    public static String getOAuth2ClientSecret() {
        return config.getString("api.oauth2.clientSecret");
    }

    public static String getOAuth2TokenUrl() {
        return config.getString("api.oauth2.tokenUrl");
    }

    public static String getOAuth2Scope() {
        return config.getString("api.oauth2.scope");
    }

    public static String getOAuth2GrantType() {
        return config.getString("api.oauth2.grantType");
    }
}