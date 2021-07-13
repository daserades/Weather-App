package com.nisaefendioglu.weatherapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

public class ActivityFragment extends Fragment {
    String city;
    String apikey = "3f8c9db425f5691cb59026f85546237e";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.activity_main, container,false);
        ImageView imageView = viewGroup.findViewById(R.id.image);
        TextView text = viewGroup.findViewById(R.id.text);
        RecyclerView countries = viewGroup.findViewById(R.id.countries);
        Button enterButton = viewGroup.findViewById(R.id.enterButton);
        TextView country = viewGroup.findViewById(R.id.country);
        TextView temp = viewGroup.findViewById(R.id.temp);

        return viewGroup;



        }
    }

