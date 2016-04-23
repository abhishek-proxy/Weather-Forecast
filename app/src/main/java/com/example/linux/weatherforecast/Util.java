package com.example.linux.weatherforecast;

/**
 * Created by Linux on 4/24/16.
 */
public class Util {

    public static String[] getCityArray(String cities){
        String[] citesList = cities.split("\\s*,\\s*");
        return citesList;
    }
}
