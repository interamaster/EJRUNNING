package com.materiales.jrdv.ejrunning;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by joseramondelgado on 07/04/15.
 */
public class TimeTrackerDatabaseHelper {

    private static final int DATABASE_VERSION=4;
    private static final String DATABASE_NAME="timetracker.db";
    private static final String TABLE_NAME="timerecords";

    public static final String TIMETRACKER_COLUMN_ID="id";
    public static final String TIMETRACKER_COLUMN_TIME="time";
    public static final String TIMETRACKER_COLUMN_NOTES="notes";

    private  TimeTrackerOpenHelper openHelper;
    private SQLiteDatabase database;



    //creator:

    public  TimeTrackerDatabaseHelper(Context context){

        openHelper=new TimeTrackerOpenHelper(context);

        //obetenemos la writable database

        database=openHelper.getWritableDatabase();

    }


    //insert:

    public  void saveTimerecord (String time ,String notes){

        ContentValues contentValues=new ContentValues();

        contentValues.put(TIMETRACKER_COLUMN_TIME,time);
        contentValues.put(TIMETRACKER_COLUMN_NOTES,notes);

        database.insert(TABLE_NAME,null,contentValues);

    }



    private class TimeTrackerOpenHelper extends SQLiteOpenHelper {



//    public TimeTrackerOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//
//    }

        TimeTrackerOpenHelper (Context context){
            //super(context,"timetracker.db",null,2);

            super(context,DATABASE_NAME,null,DATABASE_VERSION);



        }

        @Override
        public void onCreate(SQLiteDatabase db) {

           // db.execSQL("CREATE TABLE timerecords "+ "(id INTEGER PRIMARY KEY, time TEXT, notes TEXT");

            db.execSQL(
                    "CREATE TABLE "+ TABLE_NAME + "( " +
                       TIMETRACKER_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                       TIMETRACKER_COLUMN_TIME + " TEXT, "
                    + TIMETRACKER_COLUMN_NOTES +" TEXT )"
            );

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//            db.execSQL("DROP TABLE IF EXITS timerecords");
//            onCreate(db);
                db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
                 onCreate(db);


        }

    }//de la private class TimeTrackerOpenHelper
}//de la class initial  TimeTrackerDatabaseHelper
