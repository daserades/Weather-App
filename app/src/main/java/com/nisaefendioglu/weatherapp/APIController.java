package com.nisaefendioglu.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIController {
    @GET("data/2.5/weather?")
    Call<RetrofitModel> getWeatherData(@Query("lat") String lat, @Query("lon") String lon, @Query("cnt") String cnt , @Query("APIKey") String apiKey);

    //  @GET("2.5/find?lat={lat}&lon={lon}&cnt={cnt}&appid={API key}")
    //    Call<RetrofitModel> getWeatherData(@Query("lat") String lat, @Query("lon") String lon, @Query("cnt") String cnt , @Query("APIKey") String apiKey);
    //
}
