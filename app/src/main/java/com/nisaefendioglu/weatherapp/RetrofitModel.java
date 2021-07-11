package com.nisaefendioglu.weatherapp;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


class RetrofitModel {
    @SerializedName("coord")
    public Coord coord;
    @SerializedName("sys")
    public Sys sys;
    @SerializedName("main")
    public Main main;
    @SerializedName("list")
    public List list;


    public class Coord {

        @SerializedName("lat")
        @Expose
        public Float lat;
        @SerializedName("lon")
        @Expose
        public Float lon;

    }

    public class List {

        @SerializedName("name")
        @Expose
        public String name;

    }

    public class Main {

        @SerializedName("temp")
        @Expose
        public Float temp;


    }
    public class Sys {

        @SerializedName("country")
        @Expose
        public String country;

    }


}