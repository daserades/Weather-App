package com.nisaefendioglu.weatherapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIController {
    @GET("data/2.5/weather?")
    Call<RetrofitModel> getWeatherData(@Query("lat") String lat, @Query("lon") String lon, @Query("APIKey") String apiKey);
        }
