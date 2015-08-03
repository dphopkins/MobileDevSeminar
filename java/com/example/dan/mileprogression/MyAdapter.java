package com.example.dan.mileprogression;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dan on 4/12/15.
 */

public class MyAdapter extends ArrayAdapter<Record> {

    Context context;
    private ArrayList<Record> recs;

    public MyAdapter(Context context, int textViewResourceId, ArrayList<Record> items) {
        super(context, textViewResourceId, items);
        this.context = context;
        this.recs = items;
    }

    @Override
    public View getView(int _id, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.table_view, null);
        }
        Record r = recs.get(_id);
        if (r != null) {
            TextView identification = (TextView) v.findViewById(R.id._id); // this is called identification instead of _id because _id is already defined in scope
            TextView time = (TextView) v.findViewById(R.id.time);
            TextView athlete = (TextView) v.findViewById(R.id.athlete);
            TextView nationality = (TextView) v.findViewById(R.id.nationality);
            TextView year = (TextView) v.findViewById(R.id.year);

            identification.setText(String.valueOf(r.getId()));
            time.setText(String.valueOf(r.getTime()));
            athlete.setText(String.valueOf(r.getAthlete()));
            nationality.setText(String.valueOf(r.getNationality()));
            year.setText(String.valueOf(r.getYear()));
        }
        return v;
    }
}