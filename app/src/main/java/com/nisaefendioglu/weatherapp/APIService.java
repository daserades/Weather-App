package com.nisaefendioglu.weatherapp;

import android.widget.TextView;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {

    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    public static String APIKey = "3f8c9db425f5691cb59026f85546237e";
    public static String lat ="35";
    public static String lon = "139";

}
