package com.nisaefendioglu.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class CountryData {

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @SerializedName("list")
    private String country;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public CountryData(String country, String temperature, Map<String, String> list) {
        this.country = country;
        this.temperature = temperature;
        this.list = list;
    }

    private String temperature;

    public CountryData(String country, Map<String, String> list) {
        this.country = country;
        this.list = list;
    }

    private Map<String, String> list;

    public Map<String, String> getList() {
        return list;
    }

    public void setList(Map<String, String> list) {
        this.list = list;
    }

    public CountryData(Map<String, String> list) {
        this.list = list;
    }
}
