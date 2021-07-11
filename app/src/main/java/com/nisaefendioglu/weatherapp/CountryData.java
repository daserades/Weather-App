package com.nisaefendioglu.weatherapp;

import com.google.gson.annotations.SerializedName;

public class CountryData {

    @SerializedName("list")
    private String list;
    private String country;
    private String name;
    private String temp;

    public CountryData(String list, String country, String name, String temp) {
        this.list = list;
        this.country = country;
        this.name = name;
        this.temp = temp;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
