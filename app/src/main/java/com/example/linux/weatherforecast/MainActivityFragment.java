package com.example.linux.weatherforecast;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.LinkedHashMap;
import java.util.Map;

import rx.Observable;
import java.util.Map;

import rx.Observable;
import rx.subjects.BehaviorSubject;
/**
 * Created by Linux on 4/23/16.
 */
public class MainActivityFragment extends Fragment implements MainActivityView{

    private EditText cityName;
    private Button getCityWeatherReportButton;
    private BehaviorSubject<Map<String, String>> weatherData = BehaviorSubject.create();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_activity_fragment, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeViews(view);
        setEventsForViews();
    }

    private void initializeViews(View view){
        cityName = (EditText) view.findViewById(R.id.city_name);
        getCityWeatherReportButton = (Button) view.findViewById(R.id.request_weather_report);

    }
    private void setEventsForViews() {
        getCityWeatherReportButton.setOnClickListener(v -> requestWeatherData());
    }

    private void requestWeatherData(){
        if ()

    }

    private Map<String, String> getMap(String cityName){
        Map<String, String> weatherReportRequestMap = new LinkedHashMap<>();
        weatherReportRequestMap.put("q", cityName);
        weatherReportRequestMap.put("cnt", Constants.DAYS_COUNT);
        weatherReportRequestMap.put("APPID", Constants.APP_ID);
    }



    @Override
    public void cityWetherReport(Data weatherData) {

    }

    @Override
    public Observable<Map<String, String>> getWeatherReport() {
        return null;
    }
}
