package org.example;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.example.util.TestConstants;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class TestPOST {

    private JSONObject request;

    @BeforeClass
    public void setup(){

        request = new JSONObject();

        request.put("name", "Raghav");
        request.put("job", "Teacher");

    }

    @Test(testName = "Teste post url users retorno 200")
    public void test_01_post()  {

        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
            .body(request.toJSONString())
        .when()
            .post(TestConstants.DEFAULT_URL)
        .then()
            .statusCode(HttpStatus.SC_CREATED);

    }

    @Test
    public void test_02_put()  {

        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
            .body(request.toJSONString())
        .when()
                .put(TestConstants.DEFAULT_URL+"/2")
        .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void test_03_patch()  {

        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
            .body(request.toJSONString())
        .when()
                .patch(TestConstants.DEFAULT_URL+"/2")
        .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void test_04_delete()  {

       when()
            .patch(TestConstants.DEFAULT_URL+"/2")
       .then()
            .statusCode(200)
            .log().all();

    }
}
