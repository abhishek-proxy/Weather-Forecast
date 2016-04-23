package com.example.linux.weatherforecast;

import rx.Observable;

import java.util.Map;

/**
 * Created by Linux on 4/23/16.
 */
public interface MainActivityView {
    void cityWetherReport(Data weatherData);

    Observable<Map<String, String>> getWeatherReport();
}
