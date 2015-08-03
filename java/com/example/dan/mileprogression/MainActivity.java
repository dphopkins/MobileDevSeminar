package com.example.dan.mileprogression;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private static final String DEBUG_TAG = "HttpExample";
    ArrayList<Record> recs = new ArrayList<Record>();
    ListView listview;
    Button downloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listview);
        downloadButton = (Button) findViewById(R.id.downloadButton);
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            downloadButton.setEnabled(true);
        } else {
            downloadButton.setEnabled(false);
        }
    }

    public void buttonClickHandler(View view) {
        new DownloadWebpageTask(new AsyncResult() {
            @Override
            public void onResult(JSONObject object) {
                processJson(object);
            }
        }).execute("https://spreadsheets.google.com/tq?key=16RWqEedY9E-g09YKYfdBAYvTz4nvesOrNGETEkECK6E");
    }

    private void processJson(JSONObject object) {

        try {
            JSONArray rows = object.getJSONArray("rows");
            for (int r = 0; r < rows.length(); ++r) {
                JSONObject row = rows.getJSONObject(r);
                JSONArray columns = row.getJSONArray("c");

                int id = columns.getJSONObject(0).getInt("v");
                String time = columns.getJSONObject(1).getString("v");
                String athlete = columns.getJSONObject(2).getString("v");
                String nationality = columns.getJSONObject(3).getString("v");
                int year = columns.getJSONObject(4).getInt("v");

                Record rec = new Record(id, time, athlete, nationality, year);
                recs.add(rec);
            }

            final MyAdapter adapter = new MyAdapter(this, R.layout.table_view, recs);
            listview.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}