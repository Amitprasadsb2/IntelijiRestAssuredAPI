package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;

import java.util.HashMap;

public class AuthService extends Basicservice {
    private static final String BASE_PATH = "/api/auth/";

    public Response login(LoginRequest payload){
        return postRequest(payload, BASE_PATH+ "login");
    }

    public Response signup(SignUpRequest payload){
        return postRequest(payload, BASE_PATH+ "signup");
    }

    public Response forgotPassword(String emailaddress){
        HashMap<String,String> payload = new HashMap<String,String>();
        payload.put("email",emailaddress);
        return postRequest(payload, BASE_PATH+"forgot-password");
    }
}
