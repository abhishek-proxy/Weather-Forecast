package com.example.linux.weatherforecast.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Linux on 4/24/16.
 */
public class CitiesData implements Parcelable {
    LinkedList<Data> citesData;

    public LinkedList<Data> getCitesData() {
        return citesData;
    }

    public void setCitesData(LinkedList<Data> citesData) {
        this.citesData = citesData;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelableArray(citesData.toArray(new DailyReport[]{}), flags);
    }

    public CitiesData() {
    }

    protected CitiesData(Parcel in) {
        this.citesData = new LinkedList(Arrays.asList(in.readParcelableArray(CitiesData.class.getClassLoader())));
    }

    public static final Parcelable.Creator<CitiesData> CREATOR = new Parcelable.Creator<CitiesData>() {
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
