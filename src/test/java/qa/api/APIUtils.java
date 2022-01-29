package qa.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class APIUtils {
    private Response response;
    private RequestSpecification request;

    public void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    public void setQueryParameter(String queryParameter){
        if (request == null) {
            request = given().queryParam(queryParameter);
        } else {
            request.queryParam(queryParameter);
        }
    }

    public void setHeader(String headerName, String headerValue) {
        if (request == null) {
            request = given().header(headerName, headerValue);
        } else {
            request.header(headerName, headerValue);
        }
    }

    public Response getResponse(String path) {
        return request.get(path);
    }

    public boolean validateResponseCode(Response response, int expectedStatusCode) {
        if (response.statusCode() == expectedStatusCode) {
            return true;
        } else return false;
    }
}
