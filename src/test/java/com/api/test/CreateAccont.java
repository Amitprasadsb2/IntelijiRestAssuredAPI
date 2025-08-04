package com.api.test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccont {
    @Test(description = "Verify the create account API")

    public void createaccounttest(){

        SignUpRequest signUpRequest = new SignUpRequest.Builder()
                .userName("Sanat1234")
                .email("sanat4@gmail.com")
                .firstName("Sanat4")
                .lastName("Kumar4")
                .password("sanat@1234")
                .mobileNumber("3282425235")
                .build();

        //Just add test

        AuthService authService = new AuthService();
        Response response = authService.signup(signUpRequest);
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);

    }

}
