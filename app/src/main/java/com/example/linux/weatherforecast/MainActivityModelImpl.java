package com.example.linux.weatherforecast;

import com.example.linux.weatherforecast.Data.Data;

import java.util.Map;

import rx.Observable;

/**
 * Created by Linux on 4/23/16.
 */
public class MainActivityModelImpl implements MainActivityModel {
    ForecastService service;
    public MainActivityModelImpl(ForecastService service){
        this.service = service;
    }

    @Override
    public Observable<Data> getcityWeather(Map<String, String> cityWeatherRequestMap) {
        return service.getcityWeatherReport(cityWeatherRequestMap.get("cityName"), cityWeatherRequestMap.get("count"), cityWeatherRequestMap.get("APPID"));
    }
}
