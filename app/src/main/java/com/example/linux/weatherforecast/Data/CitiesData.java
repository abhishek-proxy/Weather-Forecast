package com.example.linux.weatherforecast.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Linux on 4/24/16.
 */
public class CitiesData implements Parcelable {
    LinkedList<Data> citiesData;

    public LinkedList<Data> getCitiesData() {
        return citiesData;
    }

    public void setCitiesData(LinkedList<Data> citiesData) {
        this.citiesData = citiesData;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelableArray(citiesData.toArray(new Data[]{}), flags);
    }

    public CitiesData() {
    }

    protected CitiesData(Parcel in) {
        this.citiesData = new LinkedList(Arrays.asList(in.readParcelableArray(Data.class.getClassLoader())));
    }

    public static final Creator<CitiesData> CREATOR = new Creator<CitiesData>() {
        @Override
        public CitiesData createFromParcel(Parcel source) {
            return new CitiesData(source);
        }

        @Override
        public CitiesData[] newArray(int size) {
            return new CitiesData[size];
        }
    };
}
