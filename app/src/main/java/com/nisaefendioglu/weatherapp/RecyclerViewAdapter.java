package com.nisaefendioglu.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {

    private ArrayList<CountryData> countryData;
    private LayoutInflater inflater;
    Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<CountryData> mModelExamples) {
        inflater = LayoutInflater.from(context);
        this.countryData = mModelExamples;
        this.mContext = context;
    }

    @NonNull

    @Override
    public MyHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.country_item_layout, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerViewAdapter.MyHolder holder, int position) {
        CountryData selectedModelExample = countryData.get(position);
        holder.setData(selectedModelExample, position);
    }

    @Override
    public int getItemCount() {
        return countryData.size();

    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView txtcountryName;
        private TextView txttemperature;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            txtcountryName = itemView.findViewById(R.id.countryName);
            txttemperature = itemView.findViewById(R.id.temperature);
        }


        public void setData(CountryData selectedModelExample, int position) {
            String countryName = selectedModelExample.getName();
            String temperature = selectedModelExample.getTemp();
            txtcountryName.setText(countryName);
            txttemperature.setText(temperature);

        }


    }
}
