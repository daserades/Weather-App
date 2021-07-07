package com.nisaefendioglu.weatherapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

public interface APIController {
    @GET("/servejson") //gönderecek istegimizin url i json formatında.
    void getJsonValues(Call<RetrofitModel[]> response); //json array
        }
