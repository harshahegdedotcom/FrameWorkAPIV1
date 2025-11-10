package com.api.tests;

import com.api.base.AuthService;
import com.api.listeners.TestListener;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)
public class ForgotPasswordTest {
    @Test(description = "Verify Forgot Password")
    public void forgotPasswordTest() {
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("harsharamhegde@gmail.com");
        Assert.assertEquals(response.asPrettyString(), "If your email exists in our system, you will receive reset instructions.");

    }
}
