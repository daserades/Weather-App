package com.nisaefendioglu.weatherapp;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {

    private Context context;
    private List<CountryData> list;

    public Adapter(Context context, List<CountryData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.country_item_layout, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  Adapter.AdapterViewHolder holder, int position) {
        CountryData data = list.get(position);

        holder.countryName.setText(data.getCountry());
        holder.temperature.setText(data.getTemperature());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView countryName, temperature;

        public AdapterViewHolder(@NonNull  View itemView) {
            super(itemView);

            countryName = itemView.findViewById(R.id.countryName);
            temperature = itemView.findViewById(R.id.temperature);
        }
    }

}

