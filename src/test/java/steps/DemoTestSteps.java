package steps;

import io.restassured.module.jsv.JsonSchemaValidatorSettings;
import io.restassured.response.Response;
import models.Customer;
import setup.ApiCalls;
import utils.Methods;
import utils.TestContext;
import utils.TestDataKey;
import io.restassured.module.jsv.JsonSchemaValidator;

public class DemoTestSteps extends  ApiCalls {
    Response response;
    public void preparePayload(){

    }

    public Response executeRequest(Methods method, String endpoint, Object payload){
       response = switch (method){
           case GET -> getRequest(endpoint);
           case POST -> postRequest(endpoint, payload);
           case PUT -> putRequest(endpoint, payload);
           case DELETE -> deleteRequest(endpoint);
       };
       return response;
    }

    public void validate200Status(TestDataKey key){
        TestContext.getTestContext()
                .get(key, Response.class)
                        .then()
                                .statusCode(200);
    }

    public void validateSchema(TestDataKey key, String schema){
        TestContext.getTestContext()
                .get(key, Response.class)
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schema)
                        .using(new JsonSchemaValidatorSettings()
                                .with().checkedValidation(false)));
    }

    public void validateDatabase(){

    }
}
