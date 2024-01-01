package org.selenium.pom.utils;

import io.restassured.http.Cookies;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiRequestUtil {

    public static Response sendRequest(String method, String endpoint, Cookies cookies) {
        String baseUri = ConfigLoader.getInstance().getBaseUrl();

        Response response;

        if ("GET".equalsIgnoreCase(method)) {
            response = given().baseUri(baseUri)
                    .cookies(cookies)
                    .when().get(endpoint)
                    .then()
                    .extract().response();
        } else if ("POST".equalsIgnoreCase(method)) {
            response = given().baseUri(baseUri)
                    .cookies(cookies)
                    .when().post(endpoint)
                    .then()
                    .extract().response();
        } else {
            throw new IllegalArgumentException("Unsupported HTTP method: " + method);
        }

        return response;
    }
}
