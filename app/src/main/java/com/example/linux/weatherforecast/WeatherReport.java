package com.example.linux.weatherforecast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.linux.weatherforecast.Data.DailyReport;

public class WeatherReport extends AppCompatActivity {
    DailyReport dailyReport;
    TextView date, main, description, pressure, tempDay, tempNight, tempMin, tempMax, tempEve, tempMorn, humidity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_report);
        getDataFromIntent();
        initializeViews();
        setData();
    }

    private void setData(){
        date.setText("Date: " + Util.getDateFromTimeStamp(dailyReport.getDt()));
        main.setText("Weather Main: " + dailyReport.getWeather().get(0).getMain());
        description.setText("Desciption: " + dailyReport.getWeather().get(0).getDescription());
        pressure.setText("Pressure " + dailyReport.getPressure() + "");
        tempDay.setText("Day Temperature: " + dailyReport.getTemp().getDay() + "");
        tempNight.setText("Night Temperature: " + dailyReport.getTemp().getNight() + "");
        tempMin.setText("Minimum Temperature: " + dailyReport.getTemp().getMin() + "");
        tempMax.setText("Maximum Temperature: " + dailyReport.getTemp().getMax() + "");
        tempEve.setText("Evening Temperature: " + dailyReport.getTemp().getEve() + "");
        tempMorn.setText("Morning Temperature: " + dailyReport.getTemp().getMorn());
        humidity.setText("Humidity: " + dailyReport.getHumidity());
    }

    private void initializeViews(){
        date = (TextView) findViewById(R.id.date);
        main = (TextView) findViewById(R.id.main);
        description = (TextView) findViewById(R.id.description);
        pressure = (TextView) findViewById(R.id.pressure);
        tempDay = (TextView) findViewById(R.id.temp_day);
        tempNight = (TextView) findViewById(R.id.temp_night);
        tempMin = (TextView) findViewById(R.id.temp_min);
        tempMax = (TextView) findViewById(R.id.temp_max);
        tempEve = (TextView) findViewById(R.id.temp_eve);
        tempMorn = (TextView) findViewById(R.id.temp_morn);
        humidity = (TextView) findViewById(R.id.humidity);
    }

    private void getDataFromIntent(){
        Bundle b = getIntent().getExtras();
        dailyReport = b.getParcelable("DayReport");
    }
}
