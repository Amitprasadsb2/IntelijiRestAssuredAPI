package com.api.test;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ForgotPassword {
    @Test(description = "Verify the Forgot password API")

    public void forgotpasswordtest(){
    //update niharika changes
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("sanat@gmail.com");
        System.out.println(response.asPrettyString());
    }



}
