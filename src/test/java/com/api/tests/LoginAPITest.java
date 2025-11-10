package com.api.tests;

import com.api.base.AuthService;
import com.api.listeners.TestListener;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)
public class LoginAPITest {
    @Test(description = "Verify Login API is working")
    public void loginTest() {
        LoginRequest loginRequest =new LoginRequest("harsharamhegde","harsharamhegde");
        AuthService authService = new AuthService();

        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());

        Assert.assertNotNull(loginResponse.getToken());
        Assert.assertEquals(loginResponse.getEmail(), "harsharamhegde@gmail.com");


    }
}
