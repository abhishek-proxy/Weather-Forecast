package com.example.linux.weatherforecast;

import com.example.linux.weatherforecast.Data.Data;

import java.util.Map;

import rx.Observable;

/**
 * Created by Linux on 4/23/16.
 */
public interface MainActivityModel {

    Observable<Data> getcityWeather(Map<String, String> cityWeatherRequestMap);
}
