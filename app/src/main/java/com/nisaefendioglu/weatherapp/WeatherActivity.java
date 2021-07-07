package com.nisaefendioglu.weatherapp;

public class WeatherActivity {
    private String country;
    private String weather;

    public WeatherActivity(String country, String weather){
        this.country = country;
        this.weather = weather;
    }

    public String getCountry(){
        return country;
    }

    public String getWeather(){
        return weather;
    }

}
