package com.api.base;

import io.restassured.response.Response;

public class AccountController extends Basicservice {

    private static final String BASE_PATH = "/api/accounts";

    public Response getAccountUser(String token){
        setAuthToken(token);
        return getRequest(BASE_PATH+"/user");
    }

}
