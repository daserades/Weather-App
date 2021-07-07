package com.nisaefendioglu.weatherapp;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class Adapter extends ArrayAdapter<WeatherActivity> {

    public Adapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
