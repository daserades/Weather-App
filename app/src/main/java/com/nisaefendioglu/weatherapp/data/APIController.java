package com.nisaefendioglu.weatherapp.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIController {

   String BASE_URL = "https://api.openweathermap.org/data/2.5/";
   @GET("CityJSON")
   Call<List<com.nisaefendioglu.weatherapp.model.List>> getCityList();

}
