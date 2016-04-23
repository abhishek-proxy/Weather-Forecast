package com.example.linux.weatherforecast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MainActivityPresenter(mainActivityModel(), mainActivityView());
    }

    private MainActivityView mainActivityView(){
        return (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.main_activity_fragment);
    }

    private MainActivityModel mainActivityModel(){
        return new MainActivityModelImpl(service());
    }

    private ForecastService service(){
       ForecastService forecastService = restAdapterBuilder().setEndpoint(Constants.BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL).build().create(ForecastService.class);
        return forecastService;
    }

    private RestAdapter.Builder restAdapterBuilder() {
        return new RestAdapter.Builder().setConverter(new GsonConverter(new GsonBuilder().create()));
    }


}
