package com.example.retfofitmvvm.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.retfofitmvvm.R;
import com.example.retfofitmvvm.serviceapi.MovieApiService;
import com.example.retfofitmvvm.serviceapi.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    /*
    Used to abstract data source details and provides a clean API
    for ViewModel to fetch and manage data.
     */
    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData() {
        MovieApiService movieApiService = RetrofitInstance.getService();
        Call<Result> call = movieApiService.getPopularMovies(application.getApplicationContext().getString(R.string.api_key));
        // engeue ia asnchroyonous method for makin http request
        // perform network request in background thread and hande the response on main UI thread
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                //Success
                Result result = response.body();
                if(result!=null && result.getResults()!=null){
                    movies = (ArrayList<Movie>)result.getResults();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }


}
