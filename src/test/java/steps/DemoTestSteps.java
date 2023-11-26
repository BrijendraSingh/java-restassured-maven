package steps;

import io.restassured.response.Response;
import setup.ApiCalls;

public class DemoTestSteps {
    Response response;
    public void preparePayload(){

    }

    public void executeRequest(){
        response = new ApiCalls().DemoTestApi();
    }

    public void validate200Status(){
        response.then().statusCode(200);
    }

    public void validateSchema(){

    }

    public void validateResponse(){

    }

    public void validateDatabase(){

    }
}
