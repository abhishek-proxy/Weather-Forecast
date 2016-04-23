package com.example.linux.weatherforecast.Data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by Linux on 4/23/16.
 */
public class Data implements Parcelable {
    City city;
    String cod;
    float message;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public LinkedList<DailyReport> getList() {
        return list;
    }

    public void setList(LinkedList<DailyReport> list) {
        this.list = list;
    }

    int cnt;
    LinkedList<DailyReport> list;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.city, flags);
        dest.writeString(this.cod);
        dest.writeFloat(this.message);
        dest.writeInt(this.cnt);
        dest.writeParcelableArray(list.toArray(new DailyReport[]{}), flags);
    }

    public Data() {
    }

    protected Data(Parcel in) {
        this.city = in.readParcelable(City.class.getClassLoader());
        this.cod = in.readString();
        this.message = in.readFloat();
        this.cnt = in.readInt();
        this.list = new LinkedList(Arrays.asList(in.readParcelableArray(DailyReport.class.getClassLoader())));
    }

    public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel source) {
            return new Data(source);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}
