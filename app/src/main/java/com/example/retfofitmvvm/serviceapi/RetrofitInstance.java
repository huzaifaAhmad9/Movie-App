package com.example.retfofitmvvm.serviceapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    // retrofit library is used to making http request to web service or APIs

    /*
    Retrofit instance class actss as a central configuration point for defining how HTTPS
    request and responses should be handled
    */

    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://api.themoviedb.org/3/";

    public static MovieApiService getService(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(MovieApiService.class);
    }
}
