package com.nisaefendioglu.weatherapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CountryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<CountryData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        recyclerView = findViewById(R.id.countries);
        list = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        Adapter adapter = new Adapter(this,list);
        recyclerView.setAdapter(adapter);




    }

}
