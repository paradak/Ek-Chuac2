package com.example.raul__000.myfirstapp;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.Random;


public class ActivityBD extends ListActivity {

    private HistoryBD datasource;
    private List<Historial> values;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        datasource = new HistoryBD(this);
        datasource.open();
        values = datasource.getAllHistorial();
        // use the SipleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<Historial> adapter = new ArrayAdapter<Historial>(this,
                android.R.layout.simple_expandable_list_item_1, values);
        setListAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity3, menu);
        return true;
    }

    // Will be called via the onClick attribute
    // of the buttons in main.xml
    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Historial> adapter = (ArrayAdapter<Historial>) getListAdapter();
        Historial historial = null;
        switch (view.getId()) {
            case R.id.add:

                /*
                String[] historials = new String[] {"Cool", "Very nice", "Hate it" };
                int nextInt = new Random().nextInt(3);
                // save the new comment to the database
                historial = datasource.createHistorial("sfdsd");
                adapter.add(historial);*/
                Intent act = new Intent(this, MyActivity.class);
                startActivity(act);
                break;
            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    historial = (Historial) getListAdapter().getItem(0);
                    datasource.deleteHistorial(historial);
                    adapter.remove(historial);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }

}

