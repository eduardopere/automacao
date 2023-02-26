package org.example;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class TestGET {

    @Test
    public void test_01 ()  {
        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);

    }

    @Test
    public void test_02()   {

        given()
            .get("https://reqres.in/api/users?page=2")
        .then()
            .statusCode(200)
            .body("data.id[0]", equalTo(7));

    }
    @Test
    public void test_03()   {

        given()
            .get("https://reqres.in/api/users?page=2")
        .then()
            .statusCode(200)
            .body("data.id[1]", equalTo(8))
            .body("data.first_name", hasItems("Lindsay"));

    }
    @Test
    public void test_04()   {

        given()
            .get("https://reqres.in/api/users?page=2")
        .then()
            .statusCode(200)
            .body("data.id[2]", equalTo(9));

    }
}
