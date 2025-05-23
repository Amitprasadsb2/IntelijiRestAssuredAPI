package com.api.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginApiTest {

    @Test(description = "Verify if Login API working")

    public void logintest(){
        RestAssured.baseURI = "http://64.227.160.186:8080";
        RequestSpecification x = RestAssured.given();
        RequestSpecification y = x.header("Content-Type","application/json");
        RequestSpecification z = y.body("{\"username\": \"amitprasad\",\"password\": \"Amit@12345\"}");
        Response response = z.post("/api/auth/login");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test (description = "Checking the response for GetProfile")

    public void checkingProfile(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbWl0cHJhc2FkIiwiaWF0IjoxNzQ3ODEyNTI4LCJleHAiOjE3NDc4MTYxMjh9.Gq1SSc2U9ecda27n2-6SbeHjqOWfvGDglK8EXc5JI6U"; // Replace with your actual token

        Response response = given()
                .baseUri("http://64.227.160.186:8080")
//                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .get("/api/users/profile");

        System.out.println(response.asPrettyString());
    }
}
