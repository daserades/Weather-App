package com.nisaefendioglu.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;
import com.nisaefendioglu.weatherapp.data.Adapter;
import com.nisaefendioglu.weatherapp.data.City;
import com.nisaefendioglu.weatherapp.data.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String apikey = "3f8c9db425f5691cb59026f85546237e";
    String city;
    Button enterButton;
    TextView countryMain,tempMain, back;
    TextView countryName,temperature;
    TextInputLayout cityAdd;
    double tempNo;

    private List<City> cityList;
    private RecyclerView countries;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        define();
        recyclerViewSettings();
        onClickEnter();
        onClickBack();
        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();
        fetchCity();

    }

        void define(){
            countryMain = findViewById(R.id.countryMain);
            tempMain = findViewById(R.id.tempMain);
            enterButton = findViewById(R.id.enterButton);
            countryName = findViewById(R.id.countryName);
            temperature = findViewById(R.id.temperature);
            cityAdd = findViewById(R.id.cityAdd);
            back = findViewById(R.id.back);
            back.setVisibility(View.INVISIBLE);
        }


        void recyclerViewSettings() {

            //Recyclerview settings
            countries = findViewById(R.id.countries);
            countries.setHasFixedSize(true);
            countries.setLayoutManager(new LinearLayoutManager(this));
            cityList = new ArrayList<>();
        }



        void onClickBack(){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryMain.setVisibility(View.INVISIBLE);
                tempMain.setVisibility(View.INVISIBLE);
                back.setVisibility(View.INVISIBLE);
            }
        });
        }
        void onClickEnter(){
        //SEARCH
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back.setVisibility(View.VISIBLE);
                countryMain.setVisibility(View.VISIBLE);
                tempMain.setVisibility(View.VISIBLE);
                city = cityAdd.getEditText().getText().toString().trim();
                String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apikey;
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            Log.d("Temperature", (url));

                            JSONObject temps = response.getJSONObject("main");
                            tempNo = temps.getInt("temp");
                            tempNo = tempNo - 273.15;
                            int tempToInt = (int) tempNo;
                            countryMain.setText(city.toUpperCase());
                            tempMain.setText(tempToInt + "°C");


                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Check the city name", Toast.LENGTH_SHORT).show();

                    }
                }

                );
                queue.add(request);

            }
        });
    }

    //HOME WEATHER
    private void fetchCity(){
        String url = "http://www.json-generator.com/api/json/get/bTwqRabTqW?indent=2";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i =0; i<response.length(); i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String name = jsonObject.getString("name");
                        Double temp = jsonObject.getDouble("temp");
                        City city = new City(name,temp);
                        cityList.add(city);
                    }
                    catch (JSONException e){
                        e.printStackTrace();
                    }

                    Adapter adapter = new Adapter(MainActivity.this, cityList);
                    countries.setAdapter(adapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }


}