package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginApiTest3 {

    @Test(description = "Verify if Login API working")
    public void logintest(){
        LoginRequest loginRequest = new LoginRequest("amitprasad22","Amit@12345");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);

        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());
        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.getEmail());
        System.out.println(loginResponse.getUsername());

        Assert.assertTrue(loginResponse.getToken() != null);
        Assert.assertEquals(loginResponse.getEmail(), "amitprasad.sb2@gmail.com");

    }
}
