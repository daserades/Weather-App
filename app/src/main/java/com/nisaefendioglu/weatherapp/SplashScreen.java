package com.nisaefendioglu.weatherapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class SplashScreen extends Activity {

    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        Thread timerThread = new Thread(){
            public void run(){
                try{

                    synchronized(this){
                        wait(2000);
                    }

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        timerThread.start();
    }
}
