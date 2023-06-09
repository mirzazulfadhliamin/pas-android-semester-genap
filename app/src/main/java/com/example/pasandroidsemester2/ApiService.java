package com.example.pasandroidsemester2;

import com.example.pasandroidsemester2.queries.DetailQuery;
import com.example.pasandroidsemester2.queries.GlobalActivityQuery;
import com.example.pasandroidsemester2.queries.ListQuery;
import com.example.pasandroidsemester2.queries.ProfileQuery;
import com.example.pasandroidsemester2.queries.SearchQuery;
import com.example.pasandroidsemester2.responses.detail.ResponseGetDetail;
import com.example.pasandroidsemester2.responses.global_activity.ResponseGetGlobalActivity;
import com.example.pasandroidsemester2.responses.library.ResponseGetList;
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

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @POST("/")
    Call<ResponseGetDetail> getDetail(@Header("Authorization") String authToken, @Body DetailQuery query);

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @POST("/")
    Call<ResponseGetList> getList(@Header("Authorization") String authToken, @Body ListQuery query);

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    @POST("/")
    Call<ResponseGetGlobalActivity> getGlobalActivities(@Header("Authorization") String authToken, @Body GlobalActivityQuery query);
}
