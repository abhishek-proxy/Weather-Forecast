package com.example.linux.weatherforecast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.linux.weatherforecast.Data.Data;

public class CityWeatherForecast extends AppCompatActivity {
    private Data data;
    ListView cityDailyWeatherList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_weather_forecast);
        getDataFromIntent();
        initializeViews();
        showCityWeatherDetails();
        setEventsForViews();
    }

    private void showCityWeatherDetails(){
        cityDailyWeatherList.setAdapter(new ListAdapter(this, data.getList(), "DAILY_REPORT"));

    }

    private void initializeViews(){
        cityDailyWeatherList = (ListView) findViewById(R.id.city_daily_forecast_list);
    }

    private void setEventsForViews(){
        cityDailyWeatherList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Notes", "item clicked");
                //Data data = c.getCitiesData().get(position);
                //Navigate.toCityWeatherForecast(CitiesDetails.this, data);
            }
        });
    }




    private void getDataFromIntent(){
        Bundle b = getIntent().getExtras();
         data = b.getParcelable("data");
    }
}
