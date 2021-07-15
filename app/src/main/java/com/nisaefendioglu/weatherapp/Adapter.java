package com.nisaefendioglu.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.AdapterHolder> {

    private Context context;
    private List<City> cityList;

    public Adapter(Context context, List<City> cityList) {
        this.context = context;
        this.cityList = cityList;
    }

    @NonNull
    @Override
    public AdapterHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.country_item_layout, parent, false);
        return new AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  Adapter.AdapterHolder holder, int position) {
        City city = cityList.get(position);
        holder.countryName.setText(city.getName());
        holder.temperature.setText(city.getTemp().toString());

    }


    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public class AdapterHolder  extends RecyclerView.ViewHolder{

        TextView countryName,temperature;

        public AdapterHolder(@NonNull  View itemView) {
            super(itemView);

            countryName = itemView.findViewById(R.id.countryName);
            temperature = itemView.findViewById(R.id.temperature);
        }
    }
}
