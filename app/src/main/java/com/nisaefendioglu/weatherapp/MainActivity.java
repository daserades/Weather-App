package com.nisaefendioglu.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    public static String apikey = "3f8c9db425f5691cb59026f85546237e";
    private List<CountryData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiUtilities.getApiInterface().getCountryData(apikey).enqueue(new Callback<List<CountryData>>(){
            TextView countryName, temperature;
            @Override
            public void onResponse(Call<List<CountryData>> call, Response<List<CountryData>> response) {

                if (response.code() == 200) {
                    RetrofitModel retrofitModel = (RetrofitModel) response.body();
                    assert retrofitModel != null;
                    double temp = retrofitModel.main.temp - 273.15;
                    int tempToInt = (int) temp;

                    String country = retrofitModel.sys.country;
                    for(int i=0; i<list.size(); i++){
                        countryName.setText(country);

                    }

                    String temperatures = tempToInt + "°C";
                    temperature.setText(temperatures);

                }


            }

            @Override
            public void onFailure(Call<List<CountryData>> call, Throwable t) {

            }
        });


    }

    public void searchView (View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        SearchFragment searchFragment = new SearchFragment();
        fragmentTransaction.replace(R.id.frameLayout, searchFragment).commit();


    }


    public void temp (View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ActivityFragment activityFragment = new ActivityFragment();
        fragmentTransaction.replace(R.id.frameLayout, activityFragment).commit();
    }




}
