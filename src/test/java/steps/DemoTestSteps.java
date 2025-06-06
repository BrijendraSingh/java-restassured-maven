package steps;

import io.restassured.response.Response;
import setup.ApiCalls;
import utils.Methods;

public class DemoTestSteps extends  ApiCalls {
    Response response;
    public void preparePayload(){

    }

    public void executeRequest(Methods method, String endpoint, Object payload){
       response = switch (method){
           case GET -> getRequest(endpoint);
           case POST -> postRequest(endpoint, payload);
           case PUT -> putRequest(endpoint, payload);
           case DELETE -> deleteRequest(endpoint);
       };
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
