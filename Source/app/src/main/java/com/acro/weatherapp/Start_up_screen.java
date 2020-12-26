package com.acro.weatherapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

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
    private static final int NUM_PAGES =3;
    private ViewPager viewPager;
    private ScreenSliderPageAdapter pagerAdapter;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up_screen);

        logo = findViewById(R.id.logo);
        appname = findViewById(R.id.AppName);
        Splashbg = findViewById(R.id.splashbg);
        lottieAnimationView = findViewById(R.id.Animation);

        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSliderPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        Splashbg.animate().translationY(-2500).setDuration(1000).setStartDelay(2000);
        lottieAnimationView.animate().translationY(1800).setDuration(1000).setStartDelay(2000);

        
    }
    private class ScreenSliderPageAdapter extends FragmentStatePagerAdapter{


        public ScreenSliderPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    OnboardingFragment1 tab1 = new OnboardingFragment1();
                    return tab1;
                case 1:
                    OnboardingFragment2 tab2 = new OnboardingFragment2();
                    return tab2;
                case 2:
                    OnboardingFragment3 tab3 = new OnboardingFragment3();
                    return tab3;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
