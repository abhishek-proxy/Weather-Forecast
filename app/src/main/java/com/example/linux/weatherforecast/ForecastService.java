package com.example.linux.weatherforecast;

import java.util.Map;

import retrofit.http.FieldMap;
import rx.Observable;

import retrofit.http.GET;

/**
 * Created by Linux on 4/23/16.
 */
public interface ForecastService {
    @GET("")
    Observable<Data> getcityWeatherReport(@FieldMap Map<String,String> queryData);
}
