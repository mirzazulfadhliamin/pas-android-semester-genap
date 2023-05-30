package com.example.pasandroidsemester2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit retrofit;
    public static final String BaseURL ="https://graphql.anilist.co";

    public static Retrofit getRetrofitInstance(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BaseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }return retrofit;
    }
}
