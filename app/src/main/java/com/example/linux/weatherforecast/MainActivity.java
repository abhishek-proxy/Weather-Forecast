package com.example.linux.weatherforecast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MainActivityPresenter(mainActivityModel(), mainActivityView());
    }

    private MainActivityView mainActivityView(){
        return (MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.main_activity_fragment)
    }


}
