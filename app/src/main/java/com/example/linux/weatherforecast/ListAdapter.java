package com.example.linux.weatherforecast;

import android.app.Service;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.linux.weatherforecast.Data.CitiesData;
import com.example.linux.weatherforecast.Data.Data;

import java.util.LinkedList;

/**
 * Created by Linux on 4/24/16.
 */
public class ListAdapter extends BaseAdapter{
    Context context;
    LinkedList<Data> citiesData;
    LayoutInflater inflater;

    public ListAdapter(Context context, LinkedList<Data> citiesData){
        Log.i("Notes", context +  "");
        this.context = context;
        this.citiesData = citiesData;
    }

    @Override
    public int getCount() {
        return citiesData.size();
    }

    @Override
    public Object getItem(int position) {
        return citiesData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if (view == null){
            inflater = (LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.cities_weather_detail, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.cityName = (TextView) view.findViewById(R.id.city_name);
            viewHolder.temperature = (TextView) view.findViewById(R.id.todays_temp);
            Data data = citiesData.get(i);
            viewHolder.cityName.setText(data.getCity().getName());
            viewHolder.temperature.setText(data.getList().get(0).getTemp().getMax() + "");
            view.setTag(viewHolder);
        }
        return view;
    }


    class ViewHolder{
        TextView cityName;
        TextView temperature;
    }
}