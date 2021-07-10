package com.nisaefendioglu.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    RecyclerView countries;
    TextView countryName, temperature;
    ImageView image;
    private static Retrofit retrofit = null;
    public static final String BASE_URL = "http://api.openweathermap.org/";
    public static String APIKey = "3f8c9db425f5691cb59026f85546237e";
    public static String lat ="55.5";
    public static String lon = "37.5";
    public static String cnt = "10";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = (SearchView) findViewById(R.id.searchView);
        countries = (RecyclerView) findViewById(R.id.countries);
        countryName = (TextView)findViewById(R.id.countryName);
        temperature = (TextView)findViewById(R.id.temperature);
        image = (ImageView)findViewById(R.id.image);
        getClient();


        countryName.setOnClickListener( v ->
                startActivity(new Intent(MainActivity.this, CountryActivity.class)));
    }
    void getClient(){

        if (retrofit == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            APIController service = retrofit.create(APIController.class);
            Call<RetrofitModel> call = service.getWeatherData(lat, lon, cnt, APIKey);
            call.enqueue(new Callback<RetrofitModel>() {
                @Override
                public void onResponse(Call<RetrofitModel> call, Response<RetrofitModel> response) {
                    if (response.code() == 200) {
                        RetrofitModel retrofitModel = response.body();

                        assert retrofitModel != null;
                        double temp = retrofitModel.main.temp - 273.15;
                        int tempToInt = (int) temp;
                        String country =
                                        "Country: " + retrofitModel.sys.country;

                        countryName.setText(country);

                        String temperatures =
                                         "Temperature: " + tempToInt + "°C";

                        temperature.setText(temperatures);

                    }


                }

                @Override
                public void onFailure(Call<RetrofitModel> call, Throwable t) {
                    countryName.setText(t.getMessage());
                    temperature.setText(t.getMessage());
                }


            });

        }
    }
}