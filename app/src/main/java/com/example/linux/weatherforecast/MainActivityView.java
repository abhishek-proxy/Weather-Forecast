package com.example.linux.weatherforecast;

import com.example.linux.weatherforecast.Data.Data;

import rx.Observable;

import java.util.Map;

/**
 * Created by Linux on 4/23/16.
 */
public interface MainActivityView {
    void cityWeatherReport(Data weatherData);

    Observable<Map<String, String>> getWeatherReport();
}
