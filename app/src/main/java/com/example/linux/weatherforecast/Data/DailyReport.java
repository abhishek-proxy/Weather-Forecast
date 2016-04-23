package com.example.linux.weatherforecast.Data;

import java.util.LinkedList;

/**
 * Created by Linux on 4/23/16.
 */
public class DailyReport {
    long dt;
    Temperature temp;
    float pressure;
    int humidity;
    float speed;
    LinkedList<Weather> weather;
    int  deg;
    int clouds;
    float rain;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public LinkedList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(LinkedList<Weather> weather) {
        this.weather = weather;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public float getRain() {
        return rain;
    }

    public void setRain(float rain) {
        this.rain = rain;
    }

    public float getSnow() {
        return snow;
    }

    public void setSnow(float snow) {
        this.snow = snow;
    }

    float snow;


}
