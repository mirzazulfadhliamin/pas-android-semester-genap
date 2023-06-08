package com.example.pasandroidsemester2;

import com.example.pasandroidsemester2.queries.ProfileQuery;
import com.example.pasandroidsemester2.queries.SearchQuery;
import com.example.pasandroidsemester2.responses.profile.ResponseGetProfile;
import com.example.pasandroidsemester2.responses.search.ResponseGetSearch;

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

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @POST("/")
    Call<ResponseGetSearch> getSearch(@Header("Authorization") String authToken, @Body SearchQuery query);
}
