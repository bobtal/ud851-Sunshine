package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// COMPLETED (15) Add a class file called ForecastAdapter
// COMPLETED (22) Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>
public class ForecastAdapter extends
        RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {
    // COMPLETED (23) Create a private string array called mWeatherData
    private String[] mWeatherData;

    // COMPLETED (47) Create the default constructor (we will pass in parameters in a later lesson)
    public ForecastAdapter() {
    }

    // COMPLETED (24) Override onCreateViewHolder
    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // COMPLETED (25) Within onCreateViewHolder, inflate the list item xml into a view
        Context context = parent.getContext();
        int forecastListItemLayoutId = R.layout.forecast_list_item;
        boolean attachToRoot = false;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(forecastListItemLayoutId, parent, attachToRoot);

        // COMPLETED (26) Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter
        return new ForecastAdapterViewHolder(view);
    }

    // COMPLETED (27) Override onBindViewHolder
    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        // COMPLETED (28) Set the text of the TextView to the weather for this list item's position
        holder.mWeatherTextView.setText(mWeatherData[position]);
    }

    // COMPLETED (29) Override getItemCount
    @Override
    public int getItemCount() {
        // COMPLETED (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null
        if (mWeatherData == null) {
            return 0;
        } else {
            return mWeatherData.length;
        }
    }

    // COMPLETED (31) Create a setWeatherData method that saves the weatherData to mWeatherData
    public void setWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        // COMPLETED (32) After you save mWeatherData, call notifyDataSetChanged
        notifyDataSetChanged();
    }

    // COMPLETED (16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
    // COMPLETED (17) Extend RecyclerView.ViewHolder
    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {

        // COMPLETED (18) Create a public final TextView variable called mWeatherTextView
        public final TextView mWeatherTextView;

        // COMPLETED (19) Create a constructor for this class that accepts a View as a parameter
        public ForecastAdapterViewHolder(View itemView) {
            // COMPLETED (20) Call super(view) within the constructor for ForecastAdapterViewHolder
            super(itemView);
            // COMPLETED (21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView
            mWeatherTextView = (TextView) itemView.findViewById(R.id.tv_weather_data);
        }
    }
}
