package com.example.linux.weatherforecast.Data;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by Linux on 4/23/16.
 */
public class Data {
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
}
