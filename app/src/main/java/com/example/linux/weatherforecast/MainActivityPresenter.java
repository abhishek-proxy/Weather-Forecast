package com.example.linux.weatherforecast;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Linux on 4/23/16.
 */
public class MainActivityPresenter {
    public MainActivityPresenter(MainActivityModel model, MainActivityView view) {
        view.signIn().subscribe(map -> model.getcityWeather(map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(signInResponse -> view.userAuthenticated(signInResponse)));
    }
}
