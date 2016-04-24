package com.example.linux.weatherforecast;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.linux.weatherforecast.Data.CitiesData;
import com.example.linux.weatherforecast.Data.Data;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import rx.Observable;

import rx.subjects.BehaviorSubject;
/**
 * Created by Linux on 4/23/16.
 */
public class MainActivityFragment extends Fragment implements MainActivityView{

    private EditText cityName;
    TextView textView;
    private Button getCityWeatherReportButton;
    private BehaviorSubject<Map<String, String>> weatherData = BehaviorSubject.create();
    String citiesList[];
    private CitiesData citiesData;
    LinkedList<Data> citiesWeatherData;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_activity_fragment, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeViews(view);
        setEventsForViews();
        citiesData = new CitiesData();
        citiesWeatherData = new LinkedList<Data>();
    }

    private void initializeViews(View view){
        cityName = (EditText) view.findViewById(R.id.city_name);
        getCityWeatherReportButton = (Button) view.findViewById(R.id.request_weather_report);
        textView = (TextView) view.findViewById(R.id.test);

    }
    private void setEventsForViews() {
        getCityWeatherReportButton.setOnClickListener(v -> requestWeatherData());
    }

    private void requestWeatherData(){
        String cities = cityName.getText().toString();
        if (cities.equals(""))
            Toast.makeText(getActivity(), "Please enter city name", Toast.LENGTH_LONG);
        else
            citiesList = Util.getCityArray(cities);
            for(int i=0; i<citiesList.length; i++)
                weatherData.onNext(getMap(citiesList[i]));
    }

    private void nextActivity(){
        citiesData.setCitiesData(citiesWeatherData);
        Log.i("Notes","in next function");
        Log.i("Notes", citiesData.getCitiesData().size() + "");
        Navigate.toCityDetails(getActivity(), citiesData);
    }

    private Map<String, String> getMap(String cityName){
        Map<String, String> weatherReportRequestMap = new LinkedHashMap<>();
        weatherReportRequestMap.put("cityName", cityName);
        weatherReportRequestMap.put("count", Constants.DAYS_COUNT);
        weatherReportRequestMap.put("APPID", Constants.APP_ID);
        return weatherReportRequestMap;
    }



    @Override
    public void cityWeatherReport(Data weatherData) {
        citiesWeatherData.add(weatherData);
        if (citiesWeatherData.size() == citiesList.length)
            nextActivity();
    }

    @Override
    public Observable<Map<String, String>> getWeatherReport() {
        return weatherData.asObservable();
    }
}
