package com.example.raul__000.myfirstapp;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by @Ndelgado###.
 */

public class HistoryBD  {


    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_HISTORIAL };

    public HistoryBD(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Historial createHistorial(String historial) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_HISTORIAL, historial);
        long insertId = database.insert(MySQLiteHelper.TABLE_HISTORIAL, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_HISTORIAL,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Historial newHistorial = cursorToHistorial(cursor);
        cursor.close();
        return newHistorial;
    }

    private Historial cursorToHistorial(Cursor cursor) {
        Historial historial = new Historial();
        historial.setId(cursor.getLong(0));
        historial.setHistorial(cursor.getString(1));
        return historial;
    }


    public void deleteHistorial(Historial historial) {
        long id = historial.getId();
        System.out.println("Historial deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_HISTORIAL, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Historial> getAllHistorial() {
        List<Historial> historial = new ArrayList<Historial>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_HISTORIAL,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Historial historials = cursorToHistorial(cursor);
            historial.add(historials);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return historial;
    }




}
