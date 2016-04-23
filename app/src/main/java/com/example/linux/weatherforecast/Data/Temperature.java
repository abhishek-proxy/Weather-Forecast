package com.example.linux.weatherforecast.Data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Linux on 4/23/16.
 */
public class Temperature implements Parcelable{
    float day;
    float min;
    float max;
    float night;
    float eve;
    float morn;

    public float getDay() {
        return day;
    }

    public void setDay(float day) {
        this.day = day;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getNight() {
        return night;
    }

    public void setNight(float night) {
        this.night = night;
    }

    public float getEve() {
        return eve;
    }

    public void setEve(float eve) {
        this.eve = eve;
    }

    public float getMorn() {
        return morn;
    }

    public void setMorn(float morn) {
        this.morn = morn;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(this.day);
        dest.writeFloat(this.min);
        dest.writeFloat(this.max);
        dest.writeFloat(this.night);
        dest.writeFloat(this.eve);
        dest.writeFloat(this.morn);
    }

    public Temperature() {
    }

    protected Temperature(Parcel in) {
        this.day = in.readFloat();
        this.min = in.readFloat();
        this.max = in.readFloat();
        this.night = in.readFloat();
        this.eve = in.readFloat();
        this.morn = in.readFloat();
    }

    public static final Creator<Temperature> CREATOR = new Creator<Temperature>() {
        @Override
        public Temperature createFromParcel(Parcel source) {
            return new Temperature(source);
        }

        @Override
        public Temperature[] newArray(int size) {
            return new Temperature[size];
        }
    };
}
