package com.example.android.sunshine.utilities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.sunshine.R;

/**
 * Created by Kishan on 6/28/2017.
 */
// Done(15) Add a class called ForecastAdapter
// Done(22) Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {

    // Done(23) Create a private string array called mWeatherData
    private String[] mWeatherData;

    // Done(47) Create the default constructor (we will pass in parameters in a later lesson)
    public ForecastAdapter() {

    }
    // Done(16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
    // Done(17) Extend RecyclerView.ViewHolder
    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {


        // Done (18) Create a public final TextView variable called mWeatherTextView
        public final TextView mWeatherTextView;

        // Done (19) Create a constructor for this class that accepts a View as a parameter
        // Done(20) Call super(view)
        // Done(21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView
        public ForecastAdapterViewHolder(View view) {
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }

    }

    // Done(24) Override onCreateViewHolder
    // Done(25) Within onCreateViewHolder, inflate the list item xml into a view
    // Done(26) Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.forecast_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new ForecastAdapterViewHolder(view);
    }

// Done(27) Override onBindViewHolder
// Done(28) Set the text of the TextView to the weather for this list item's position

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder forecastAdapterViewHolder, int position) {
        String weatherForThisDay = mWeatherData[position];
        forecastAdapterViewHolder.mWeatherTextView.setText(weatherForThisDay);
    }
// Done(29) Override getItemCount
// Done(30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null

    @Override
    public int getItemCount() {
        if (null == mWeatherData) return 0;
        return mWeatherData.length;
    }
// Done(31) Create a setWeatherData method that saves the weatherData to mWeatherData
// Done(32) After you save mWeatherData, call notifyDataSetChanged

    public void setWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }
}