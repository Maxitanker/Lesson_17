package org.example;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanTest {

    private final String URL = "https://postman-echo.com";

    @Test
    void testGet() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get(URL + "/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    void testPostRaw() {
        given()
                .body("value")
                .when()
                .post(URL + "/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("value"));
    }

    @Test
    void testPostForm() {
        given()
                .multiPart("foo1", "bar1")
                .multiPart("foo2", "bar2")
                .when()
                .post(URL + "/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }



    @Test
    void testPut() {
        given()
                .body("Put test")
                .when()
                .put(URL + "/put")
                .then()
                .statusCode(200)
                .body("data", equalTo("Put test"));
    }



    @Test
    void testPatch() {
        given()
                .body("Patch test")
                .when()
                .patch(URL + "/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo("Patch test"));
    }

    @Test
    void testDelete() {
        given()
                .body("Delete test")
                .when()
                .delete(URL + "/delete")
                .then()
                .statusCode(200)
                .body("json", equalTo(null));
    }
}
