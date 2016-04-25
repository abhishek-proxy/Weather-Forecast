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
import com.example.linux.weatherforecast.Data.DailyReport;
import com.example.linux.weatherforecast.Data.Data;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by Linux on 4/24/16.
 */
public class ListAdapter extends BaseAdapter{
    Context context;
    LinkedList<Data> citiesData;
    LayoutInflater inflater;
    String from = new String("");
    LinkedList<DailyReport> dailyReports;
    ViewHolder viewHolder;
    DateHolder dateHolder;

    public ListAdapter(Context context, LinkedList<Data> citiesData){
        Log.i("Notes", context +  "");
        this.context = context;
        this.citiesData = citiesData;
    }

    public ListAdapter(Context context, LinkedList<DailyReport> dailyReports, String from){
        this.context = context;
        this.from = from;
        this.dailyReports = dailyReports;
    }

    @Override
    public int getCount() {
        if (from.equals("DAILY_REPORT"))
            return  dailyReports.size();
        else
           return citiesData.size();
    }

    @Override
    public Object getItem(int position) {
        if (from.equals("DAILY_REPORT"))
            return dailyReports.size();
        else
            return citiesData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int i, View view, ViewGroup parent) {
        viewHolder = new ViewHolder();
        dateHolder = new DateHolder();
        if (view == null){
            inflater = (LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
            if (from.equals("DAILY_REPORT")) {
                view = inflater.inflate(R.layout.daily_report_date, parent, false);
                view.setTag(dateHolder);
            }
            else {
                view = inflater.inflate(R.layout.cities_weather_detail, parent, false);
                view.setTag(viewHolder);
            }
        }

        return renderView(view, i);
    }

    private View renderView(View view, int i){
        return from.equals("DAILY_REPORT") ? showCityDailyReport(i, view) : showCitiesDetails(i, view);
    }

    private View showCityDailyReport(int i,View view){
        dateHolder.date = (TextView) view.findViewById(R.id.date);
        DailyReport dailyReport = dailyReports.get(i);
        Log.i("Notes", dailyReport.getDt() + "");
        dateHolder.date.setText(Util.getDateFromTimeStamp(dailyReport.getDt()));
        view.setTag(dateHolder);
        return view;
    }


    private View showCitiesDetails(int i, View view){
        viewHolder.leftText = (TextView) view.findViewById(R.id.left_text);
        viewHolder.rightText = (TextView) view.findViewById(R.id.right_text);
        Data data = citiesData.get(i);
        viewHolder.leftText.setText(data.getCity().getName());
        viewHolder.rightText.setText(data.getList().get(0).getTemp().getMax() + "");
        view.setTag(viewHolder);
        return view;
    }





    class ViewHolder{
        TextView leftText;
        TextView rightText;
    }

    class DateHolder{
        TextView date;
    }


}