package com.example.administrator.contacts;

import android.app.Activity;
import android.content.Context;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 9/30/2016.
 */

public class peopleAdapter extends ArrayAdapter {

    private Context context;
    private List<People> peopleProperties;


    public peopleAdapter(Context context, int resource, ArrayList<People> objects) {
        super(context, resource,objects);
        this.context = context;
        this.peopleProperties = objects;
    }

    public View getView(final int position, View convertView, ViewGroup parent){

        People pProperty = peopleProperties.get(position);

        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.people_layout, null);


        TextView firstLetter=(TextView)view.findViewById(R.id.firstLetter);
        TextView firstName=(TextView)view.findViewById(R.id.fName);
        TextView lastName=(TextView)view.findViewById(R.id.sName);

        char[] arr=pProperty.getfName().toCharArray();
        firstLetter.setText(""+arr[0]);
        firstName.setText(pProperty.getfName());
        lastName.setText(pProperty.getSecondName());

        return view;

    }

}
