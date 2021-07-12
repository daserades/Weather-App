package com.nisaefendioglu.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    String apikey = "3f8c9db425f5691cb59026f85546237e";
    private List<CountryData> list;
    TextInputLayout cityAdd;
    String city;
    TextView country,temp;
    RecyclerView countries;
    ArrayList<CountryData> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityAdd = findViewById(R.id.edit_text_city);
        country = (TextView)findViewById(R.id.country);
        temp = (TextView)findViewById(R.id.temp);


        ApiUtilities.getApiInterface().getCountryData(apikey).enqueue(new Callback<List<CountryData>>(){
            TextView countryName,temperature;

            @Override
            public void onResponse(Call<List<CountryData>> call, Response<List<CountryData>> response) {

                if (response.code() == 200) {
                    RetrofitModel retrofitModel = (RetrofitModel) response.body();
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

    public void searchView (View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        SearchFragment searchFragment = new SearchFragment();
        fragmentTransaction.replace(R.id.frameLayout, searchFragment).commit();

        city = cityAdd.getEditText().getText().toString().trim();
        String url = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apikey;
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            try {
                Log.d("Temperature", url);
                JSONObject object1 = response.getJSONObject("main");
                String temperature = object1.getString("temp");
                temp.setText(temperature);
            } catch (JSONException e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, error -> Toast.makeText(MainActivity.this, "Please check the city name", Toast.LENGTH_SHORT).show()

        );
        queue.add(request);

    }


    public void temp (View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ActivityFragment activityFragment = new ActivityFragment();
        fragmentTransaction.replace(R.id.frameLayout, activityFragment).commit();
    }




}
