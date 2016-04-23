package com.example.linux.weatherforecast.Data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Linux on 4/23/16.
 */
public class City implements Parcelable {
    String id;
    String name;
    Coordinates coord;
    String country;
    int population;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoord() {
        return coord;
    }

    public void setCoord(Coordinates coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeParcelable(this.coord, flags);
        dest.writeString(this.country);
        dest.writeInt(this.population);
    }


    protected City(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.coord = in.readParcelable(Coordinates.class.getClassLoader());
        this.country = in.readString();
        this.population = in.readInt();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };
}
