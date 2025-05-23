package com.api.test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.Testlisteners.class)
public class LoginApiTest2 {

    @Test(description = "Verify if Login API working")

    public void logintest(){
        Response response = given().baseUri("http://64.227.160.186:8080").
                header("Content-Type","application/json").body("{\"username\": \"amitprasad\",\"password\": \"Amit@12345\"}").post("/api/auth/login");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),200);
    }
}
