package com.api.test;

import com.api.base.AccountController;
import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.AccountsResponse;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AccountsTest {
    @Test (description = "Verify the existing user accounts")

    public void getExistingAccountUserTest(){
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("Amit@12345","amitprasad"));
        LoginResponse loginResponse = response.as(LoginResponse.class);

        AccountController accountController = new AccountController();
        response = accountController.getAccountUser(loginResponse.getToken());

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);






    }
}
