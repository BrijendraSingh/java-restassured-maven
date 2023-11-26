package setup;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiCalls {
    public Response DemoTestApi(){
        return RestAssured.get("users");
    }
}
