package com.tutorialscache.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomAdapter extends BaseAdapter {

    //Arrays to receive Country Names and Flags
    String [] countryNamesArr;
    int [] countryFlagsArr;

    //Context reference of MainActivity
    Context mainActivityContext;

    LayoutInflater xmlInflater=null;

    //Create Constructor of CustomAdapter which is being called from MainActivity.java while creating CustomAdapter Class Object.
    public CustomAdapter(Context mainActContext, String[] countryNames, int[] countryFlags) {
        this.mainActivityContext = mainActContext;
        this.countryNamesArr = countryNames;
        this.countryFlagsArr = countryFlags;

        //LayoutInflater will help us out to manipulate Activity XML(activity_main.xml) with predefined XML Layout(custom_row.xml)
        xmlInflater = (LayoutInflater) mainActivityContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        //Total Number of Records in Array
        return countryNamesArr.length;
    }

    @Override
    public Object getItem(int position) {
        //Return Position Because by Calling getItem we can get Item at specific position in An Array i.e countryNamesArr[0] will return Australia
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View countryItem = xmlInflater.inflate(R.layout.custom_row, null);

        //Get Reference of Views to show Text(Country Name) and Image(Flag)
        TextView countryNameText = (TextView) countryItem.findViewById(R.id.countryNameTV);
        ImageView countryFlagImage = (ImageView) countryItem.findViewById(R.id.countryFlagIV);

        //Set country Name
        countryNameText.setText(countryNamesArr[position]);
        //Set country Image
        countryFlagImage.setImageResource(countryFlagsArr[position]);

        //return CustomRow
        return countryItem;
    }
}
