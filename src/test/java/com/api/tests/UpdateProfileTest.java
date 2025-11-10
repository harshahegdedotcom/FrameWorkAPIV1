package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.listeners.TestListener;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.request.SignUpRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)
public class UpdateProfileTest {
    @Test(description = "Verify Update Profile is working")
    public void updateProfileTest() {
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("harsharamhegde", "harsharamhegde"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getUsername(), "harsharamhegde");
        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .email("harsharamhegde@gmail.com")
                .firstName("Harsha")
                .lastName("hegde")
                .mobileNumber("1234567890")
                .build();
        response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
        System.out.println(response.asPrettyString());
    }
}
