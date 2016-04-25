package com.example.linux.weatherforecast;

import java.util.Date;

/**
 * Created by Linux on 4/24/16.
 */
public class Util {

    public static String[] getCityArray(String cities){
        String[] citesList = cities.split("\\s*,\\s*");
        return citesList;
    }

    public static String getDateFromTimeStamp(long timeStamp){
        Date date = new Date(timeStamp * 1000);
        return date + "";
    }
}
