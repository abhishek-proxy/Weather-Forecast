package com.example.linux.weatherforecast;

import com.example.linux.weatherforecast.Data.Data;

import java.util.Map;

import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Query;
import rx.Observable;

import retrofit.http.GET;

/**
 * Created by Linux on 4/23/16.
 */
public interface ForecastService {
    @GET("/daily")
    Observable<Data> getcityWeatherReport(@Query("q") String cityName, @Query("cnt") String daysCount, @Query("APPID") String appId);
}
