package com.example.linux.weatherforecast;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Linux on 4/23/16.
 */
public class Navigate {

    public static void toMainActivity(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
