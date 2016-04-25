package com.example.linux.weatherforecast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.linux.weatherforecast.Data.CitiesData;
import com.example.linux.weatherforecast.Data.Data;

public class CitiesDetails extends AppCompatActivity {

    Bundle b;
    CitiesData citiesData;
    TextView test;
    private ListView cityListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities_details);
        Log.i("Notes","in city details");
        getDataFromIntent();
        initializeViews();
        showCityDetails();
        setEventsForViews();
    }

    private void showCityDetails(){
        Log.i("Notes", citiesData.getCitiesData().size() + "");
        cityListView.setAdapter(new ListAdapter(this, citiesData.getCitiesData()));
    }

    private void initializeViews(){
        cityListView = (ListView) findViewById(R.id.cities_list);
    }

    private void setEventsForViews(){
        cityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Notes", "item clicked");
                Data data = citiesData.getCitiesData().get(position);
                Navigate.toCityWeatherForecast(CitiesDetails.this, data);
            }
        });
    }

    private void getDataFromIntent(){
        Bundle b = getIntent().getExtras();
        citiesData = b.getParcelable("citiesData");
    }

}
