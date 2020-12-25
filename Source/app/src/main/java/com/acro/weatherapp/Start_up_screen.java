package com.acro.weatherapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class Start_up_screen extends AppCompatActivity {

    ImageView logo,Splashbg;
    TextView appname;
    LottieAnimationView lottieAnimationView;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up_screen);

        logo = findViewById(R.id.logo);
        appname = findViewById(R.id.AppName);
        Splashbg = findViewById(R.id.splashbg);
        lottieAnimationView = findViewById(R.id.Animation);

        Splashbg.animate().translationY(-2200).setDuration(1000).setStartDelay(2000);
        lottieAnimationView.animate().translationY(1800).setDuration(1000).setStartDelay(2000);
        logo.animate().alphaBy(0).alpha(1).translationY(300).setDuration(1000).setStartDelay(2200);
        appname.animate().alpha(0).alphaBy(1).translationY(300).setDuration(1000).setStartDelay(2200);
        
    }
}