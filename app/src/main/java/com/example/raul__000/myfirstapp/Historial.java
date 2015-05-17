package com.example.raul__000.myfirstapp;

import android.app.ListActivity;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.Random;

/**
 * Created by @Ndelgado###.
 */
public class Historial extends ListActivity {


    private long id;
    private String historial;

    public void Historial() {

    }

    public void nada(){

    }


    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return historial;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
