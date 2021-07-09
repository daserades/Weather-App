package com.nisaefendioglu.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    TextView weatherData , weatherData2, weatherData3;
    private static Retrofit retrofit = null;
    public static final String BASE_URL = "https://api.openweathermap.org/";
    public static String APIKey = "3f8c9db425f5691cb59026f85546237e";
    public static String lat ="41.015137";
    public static String lon = "28.979530";
    public static String lat2 ="40.977779";
    public static String lon2 = "27.515278";
    public static String lat3 ="39.766193";
    public static String lon3 = "30.526714";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = (SearchView) findViewById(R.id.searchView);
        weatherData = (TextView) findViewById(R.id.weatherData);
        weatherData2 = (TextView) findViewById(R.id.weatherData2);
        weatherData3 = (TextView) findViewById(R.id.weatherData3);



        getClient();

    }
    void getClient(){
        if (retrofit == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            APIController service = retrofit.create(APIController.class);
            Call<RetrofitModel> call = service.getWeatherData(lat, lon, APIKey);
            Call<RetrofitModel> call2 = service.getWeatherData(lat2, lon2, APIKey);
            Call<RetrofitModel> call3 = service.getWeatherData(lat3, lon3, APIKey);
            call.enqueue(new Callback<RetrofitModel>() {
                @Override
                public void onResponse(Call<RetrofitModel> call, Response<RetrofitModel> response) {
                    if (response.code() == 200) {
                        RetrofitModel retrofitModel = response.body();
                        assert retrofitModel != null;
                        double temp = retrofitModel.main.temp - 273.15;
                        int tempToInt = (int) temp;
                        String strWeather =
                                //"Bulut: " + retrofitModel.weather.description + "\n" + //column yetersiz
                                "Ülke: " + retrofitModel.sys.country + "\n" +
                                        "Yer: " + retrofitModel.name + "\n" +
                                        "Sıcaklık: " + tempToInt + "°C" + "\n" +
                                        "Nem Oranı: " + retrofitModel.main.humidity + "\n" +
                                        "Basınç Oranı: " + retrofitModel.main.pressure;


                        weatherData.setText(strWeather);


                    }


                }

                @Override
                public void onFailure(Call<RetrofitModel> call, Throwable t) {
                    weatherData.setText(t.getMessage());
                }


            });

            call2.enqueue(new Callback<RetrofitModel>() {
                @Override
                public void onResponse(Call<RetrofitModel> call2, Response<RetrofitModel> response) {
                    if (response.code() == 200) {
                        RetrofitModel retrofitModel = response.body();
                        assert retrofitModel != null;
                        double temp = retrofitModel.main.temp - 273.15;
                        int tempToInt = (int) temp;
                        String strWeather =
                                        "Ülke: " + retrofitModel.sys.country + "\n" +
                                        "Yer: " + retrofitModel.name + "\n" +
                                        "Sıcaklık: " + tempToInt + "°C" + "\n" +
                                        "Nem Oranı: " + retrofitModel.main.humidity + "\n" +
                                        "Basınç Oranı: " + retrofitModel.main.pressure;


                        weatherData2.setText(strWeather);


                    }

                }

                @Override
                public void onFailure(Call<RetrofitModel> call2, Throwable t) {
                    weatherData2.setText(t.getMessage());

                }

            });

            call3.enqueue(new Callback<RetrofitModel>() {
                @Override
                public void onResponse(Call<RetrofitModel> call3, Response<RetrofitModel> response) {
                    if (response.code() == 200) {
                        RetrofitModel retrofitModel = response.body();
                        assert retrofitModel != null;
                        double temp = retrofitModel.main.temp - 273.15;
                        int tempToInt = (int) temp;
                        String strWeather =
                                        "Ülke: " + retrofitModel.sys.country + "\n" +
                                        "Yer: " + retrofitModel.name + "\n" +
                                        "Sıcaklık: " + tempToInt + "°C" + "\n" +
                                        "Nem Oranı: " + retrofitModel.main.humidity + "\n" +
                                        "Basınç Oranı: " + retrofitModel.main.pressure;


                        weatherData3.setText(strWeather);


                    }

                }

                @Override
                public void onFailure(Call<RetrofitModel> call3, Throwable t) {
                    weatherData3.setText(t.getMessage());

                }

            });
        }
    }
}