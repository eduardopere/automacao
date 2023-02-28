package org.example;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.example.util.TestConstants;
import org.junit.rules.TestName;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class TestGET {

    @Test(testName = "Teste get-01 url users retorno 200")

    public void test_01 ()  {
        Response response = get(TestConstants.DEFAULT_URL_GET);

        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, HttpStatus.SC_OK);

    }

    @Test(testName = "Teste get-02 url users retorno 200")

    public void test_02()   {

        given()
            .get(TestConstants.DEFAULT_URL_GET)
        .then()
            .statusCode(HttpStatus.SC_OK)
            .body("data.id[0]", equalTo(7));

    }
    @Test(testName = "Teste get-03 url users retorno 200")

    public void test_03()   {

        given()
            .get(TestConstants.DEFAULT_URL_GET)
        .then()
            .statusCode(HttpStatus.SC_OK)
            .body("data.id[1]", equalTo(8))
            .body("data.first_name", hasItems("Lindsay"));

    }
    @Test(testName = "Teste get-04 url users retorno 200")

    public void test_04()   {

        given()
            .get(TestConstants.DEFAULT_URL_GET)
        .then()
            .statusCode(HttpStatus.SC_OK)
            .body("data.id[2]", equalTo(9));

    }
}
