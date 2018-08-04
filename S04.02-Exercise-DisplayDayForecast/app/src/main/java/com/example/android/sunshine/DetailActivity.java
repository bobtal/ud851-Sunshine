package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    private TextView weatherDayDataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        weatherDayDataTextView = (TextView) findViewById(R.id.tv_weather_day_data);

        // COMPLETED (2) Display the weather forecast that was passed from MainActivity
        Intent startingIntent = getIntent();
        if (startingIntent != null) {
            if (startingIntent.hasExtra(Intent.EXTRA_TEXT)) {
                String weatherDayDataString = startingIntent.getStringExtra(Intent.EXTRA_TEXT);
                weatherDayDataTextView.setText(weatherDayDataString);
            }
        }
    }
}