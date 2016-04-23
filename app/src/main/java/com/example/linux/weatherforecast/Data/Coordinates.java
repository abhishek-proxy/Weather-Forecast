package com.example.linux.weatherforecast.Data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Linux on 4/23/16.
 */
public class Coordinates implements Parcelable{
    double lat;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    double lon;

    public static final Parcelable.Creator<Coordinates> CREATOR =
            new Parcelable.Creator<Coordinates>() {
                public Coordinates createFromParcel(Parcel source) {
                    return new Coordinates(source);
                }

                public Coordinates[] newArray(int size) {
                    return new Coordinates[size];
                }
            };

    public Coordinates(Parcel source){
        lat = source.readDouble();
        lon = source.readDouble();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(lat);
        dest.writeDouble(lon);
    }
}
