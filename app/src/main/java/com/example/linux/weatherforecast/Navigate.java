package com.example.linux.weatherforecast;

import android.content.Context;
import android.content.Intent;

import com.example.linux.weatherforecast.Data.CitiesData;

/**
 * Created by Linux on 4/23/16.
 */
public class Navigate {

    public static void toMainActivity(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static void toCityDetails(Context context, CitiesData citiesData){
        Intent intent = new Intent(context, CitiesDetails.class);
        intent.putExtra("citiesData",citiesData);
        context.startActivity(intent);
    }
}
