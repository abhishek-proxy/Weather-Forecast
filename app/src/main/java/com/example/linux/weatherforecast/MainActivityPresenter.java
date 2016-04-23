package com.example.linux.weatherforecast;

/**
 * Created by Linux on 4/23/16.
 */
public class MainActivityPresenter {
    public MainActivity(MainActivityModel model, MainActivityView view) {
        view.signIn().subscribe(map -> model.signIn(map).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(signInResponse -> view.userAuthenticated(signInResponse)));
    }
}
