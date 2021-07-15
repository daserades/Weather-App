package com.nisaefendioglu.weatherapp;

import com.nisaefendioglu.weatherapp.model.CityList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIController {

   String BASE_URL = "https://api.openweathermap.org/data/2.5/";
   @GET("CityJSON")
   Call<List<CityList>> getCityList();

}
