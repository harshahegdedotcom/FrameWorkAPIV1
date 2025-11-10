package com.api.tests;

import com.api.base.AuthService;
import com.api.listeners.TestListener;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)
public class AccountCreationTest {
    @Test(description = "Verify Create Account Test")
    public void createAccountTest() {
        SignUpRequest signUpRequest = new SignUpRequest.Builder()
                .userName("harsha")
                .email("harsha@gmail.com")
                .firstName("Harsha")
                .lastName("hegde")
                .mobileNumber("1234567890")
                .password("password123")
                .build();
        AuthService authService = new AuthService();
        Response response = authService.signup(signUpRequest);
        Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
    }
}
