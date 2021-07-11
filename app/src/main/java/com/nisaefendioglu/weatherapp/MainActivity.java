package com.nisaefendioglu.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<CountryData> list;
    SearchView searchView;
    RecyclerView countries;
    TextView countryName, temperature;
    ImageView image;
    private static Retrofit retrofit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = (SearchView) findViewById(R.id.searchView);
        countries = (RecyclerView) findViewById(R.id.countries);
        countryName = (TextView) findViewById(R.id.countryName);
        temperature = (TextView) findViewById(R.id.temperature);
        image = (ImageView) findViewById(R.id.image);


        list = new ArrayList<>();
        recyclerView = findViewById(R.id.countries);
        list = new ArrayList<CountryData>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        Adapter adapter = new Adapter(this, list);
        recyclerView.setAdapter(adapter);

        ApiUtilities.getApiInterface().getCountryData().enqueue(new Callback<List<CountryData>>(){

            @Override
            public void onResponse(Call<List<CountryData>> call, Response<List<CountryData>> response) {
                if (response.code() == 200) {
                    RetrofitModel retrofitModel = (RetrofitModel) response.body();
                    assert retrofitModel != null;
                    double temp = retrofitModel.main.temp - 273.15;
                    int tempToInt = (int) temp;

                    String country = retrofitModel.sys.country;
                    countryName.setText(country);

                    String temperatures = tempToInt + "°C";
                    temperature.setText(temperatures);

                }
            }

            @Override
            public void onFailure(Call<List<CountryData>> call, Throwable t) {

            }
        });
    }



    }
