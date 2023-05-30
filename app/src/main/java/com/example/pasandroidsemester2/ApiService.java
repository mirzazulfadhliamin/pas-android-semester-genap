package com.example.pasandroidsemester2;

import com.example.pasandroidsemester2.queries.ProfileQuery;
import com.example.pasandroidsemester2.responses.ResponseGetProfile;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @POST("/")
    Call<ResponseGetProfile> getProfile(@Header("Authorization") String authToken, @Body ProfileQuery query);

}
