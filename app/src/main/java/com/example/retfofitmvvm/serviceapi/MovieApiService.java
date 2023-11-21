package com.example.retfofitmvvm.serviceapi;

import com.example.retfofitmvvm.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {
    // This interface defines the structure and behaviour of API request
    // Act as a bridge b/w API and application

    // Call class is used to represent network request and its response type should replace with
    // the acual data modal class that represent the expected response from the API

    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String apiKey);

}

