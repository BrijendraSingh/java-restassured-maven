package setup;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiCalls {
    public Response getRequest(String endpoint){
        return RestAssured
                .given()
                .get(endpoint);
    }

    public Response postRequest(String endpoint, Object body){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .post(endpoint);
    }

    public Response putRequest(String endpoint, Object body){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body)
                .put(endpoint);
    }

    public Response deleteRequest(String endpoint){
        return RestAssured.given()
                .delete(endpoint);
    }

}
