package com.nisaefendioglu.weatherapp;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


class RetrofitModel {

    @SerializedName("list")
    private String list;
    private String country;
    private String name;
    private String temp;
    @SerializedName("coord")
    public Coord coord;
    @SerializedName("sys")
    public Sys sys;
    @SerializedName("weather")
    public ArrayList<Weather> weather = new ArrayList<Weather>();
    @SerializedName("main")
    public Main main;

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

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public RetrofitModel(String list, String country, String name, String temp, Coord coord, Sys sys, ArrayList<Weather> weather, Main main) {
        this.list = list;
        this.country = country;
        this.name = name;
        this.temp = temp;
        this.coord = coord;
        this.sys = sys;
        this.weather = weather;
        this.main = main;
    }
}

class Weather {
    @SerializedName("id")
    public int id;
    @SerializedName("main")
    public String main;
}

class Main {
    @SerializedName("temp")
    public float temp;
}

class Sys {
    @SerializedName("country")
    public String country;

    public Sys(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

class Coord {
    @SerializedName("lon")
    public float lon;
    @SerializedName("lat")
    public float lat;

}