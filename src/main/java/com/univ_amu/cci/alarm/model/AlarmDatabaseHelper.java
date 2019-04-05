package com.univ_amu.cci.alarm.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.univ_amu.cci.alarm.model.AlarmContract.ALARMS_TABLE_NAME;

public class AlarmDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "alarms.db";

    public AlarmDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createAlarmsTable(db);

        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        dropAlarmsTable(db);
        createAlarmsTable(db);
        /* TODO : supprimer la table avec dropAlarmsTable. */
        /* TODO : recréer la table avec createAlarmsTable. */
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static void createAlarmsTable(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + AlarmContract.ALARMS_TABLE_NAME + " ( " +
                        AlarmContract.AlarmsColumns._ID + " INTEGER PRIMARY KEY, " +
                        AlarmContract.AlarmsColumns.HOUR + " INTEGER NOT NULL, " +
                        AlarmContract.AlarmsColumns.MINUTES + " INTEGER NOT NULL, " +
                        AlarmContract.AlarmsColumns.ENABLED + " INTEGER NOT NULL);"); ////
    }

    private static void dropAlarmsTable(SQLiteDatabase db) {
        db.execSQL(
                "DROP TABLE IF EXISTS " + AlarmContract.ALARMS_TABLE_NAME + ";"); ////
    }
}
