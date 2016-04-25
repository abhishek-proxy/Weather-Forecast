package com.example.linux.weatherforecast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.linux.weatherforecast.Data.Data;

public class CityWeatherForecast extends AppCompatActivity {
    private Data data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_weather_forecast);
    }


    private void getDataFromIntent(){
        Bundle b = getIntent().getExtras();
         data = b.getParcelable("citiesData");
    }
}
