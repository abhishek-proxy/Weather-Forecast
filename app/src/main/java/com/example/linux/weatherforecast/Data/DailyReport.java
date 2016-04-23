package com.example.linux.weatherforecast.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Linux on 4/23/16.
 */
public class DailyReport implements Parcelable {
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.dt);
        dest.writeParcelable(this.temp, flags);
        dest.writeFloat(this.pressure);
        dest.writeInt(this.humidity);
        dest.writeFloat(this.speed);
        dest.writeParcelableArray(weather.toArray(new Weather[]{}), flags);
        dest.writeInt(this.deg);
        dest.writeInt(this.clouds);
        dest.writeFloat(this.rain);
        dest.writeFloat(this.snow);
    }

    public DailyReport() {
    }

    protected DailyReport(Parcel in) {
        this.dt = in.readLong();
        this.temp = in.readParcelable(Temperature.class.getClassLoader());
        this.pressure = in.readFloat();
        this.humidity = in.readInt();
        this.speed = in.readFloat();
        this.weather = new LinkedList(Arrays.asList(in.readParcelableArray(Weather.class.getClassLoader())));
        this.deg = in.readInt();
        this.clouds = in.readInt();
        this.rain = in.readFloat();
        this.snow = in.readFloat();
    }

    public static final Creator<DailyReport> CREATOR = new Creator<DailyReport>() {
        @Override
        public DailyReport createFromParcel(Parcel source) {
            return new DailyReport(source);
        }

        @Override
        public DailyReport[] newArray(int size) {
            return new DailyReport[size];
        }
    };
}
