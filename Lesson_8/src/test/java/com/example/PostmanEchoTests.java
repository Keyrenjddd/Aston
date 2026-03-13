package com.example;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTests {

    private static final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testGetRequest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get(BASE_URL + "/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers", hasKey("host"))
                .body("url", containsString("/get"));
    }

    @Test
    public void testPostRequest() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("key", "value");
        requestBody.put("number", 123);

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(BASE_URL + "/post")
                .then()
                .statusCode(200)
                .body("json.key", equalTo("value"))
                .body("json.number", equalTo(123))
                .body("headers", hasKey("content-type"))
                .body("url", equalTo(BASE_URL + "/post"));
    }

    @Test
    public void testPutRequest() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("updated", true);

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put(BASE_URL + "/put")
                .then()
                .statusCode(200)
                .body("json.updated", equalTo(true))
                .body("headers", hasKey("content-type"))
                .body("url", equalTo(BASE_URL + "/put"));
    }

    @Test
    public void testPatchRequest() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("patch", "data");

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .patch(BASE_URL + "/patch")
                .then()
                .statusCode(200)
                .body("json.patch", equalTo("data"))
                .body("headers", hasKey("content-type"))
                .body("url", equalTo(BASE_URL + "/patch"));
    }

    @Test
    public void testDeleteRequest() {
        given()
                .queryParam("id", "123")
                .when()
                .delete(BASE_URL + "/delete")
                .then()
                .statusCode(200)
                .body("args.id", equalTo("123"))
                .body("headers", hasKey("host"))
                .body("url", containsString("/delete"));
    }
}