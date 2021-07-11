package com.nisaefendioglu.weatherapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIController {

    String BASE_URL = "http://api.openweathermap.org/data/";
    @GET("data/2.5/weather?") //gönderecek istegimizin url i json formatında. //json array
    Call<RetrofitModel> getCountryData(@Query("lat") String lat, @Query("lon") String lon, @Query("APIKey") String apiKey);
}
