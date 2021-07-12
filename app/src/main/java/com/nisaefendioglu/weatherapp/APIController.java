package com.nisaefendioglu.weatherapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIController {

    String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    @GET("find?lat=55.5&lon=37.5&cnt=10&appid=3f8c9db425f5691cb59026f85546237e")
    //Call<List<CountryData>> getCountryData();

    Call<List<CountryData>> getCountryData(@Query("APIKey") String apiKey);
}
