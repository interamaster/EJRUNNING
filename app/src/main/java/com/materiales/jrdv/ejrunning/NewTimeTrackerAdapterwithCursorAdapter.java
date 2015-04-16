package com.materiales.jrdv.ejrunning;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by invitado on 16/04/15.
 */
public class NewTimeTrackerAdapterwithCursorAdapter  extends CursorAdapter{


    public NewTimeTrackerAdapterwithCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor);





        if (cursor.moveToFirst()){


            do {

                String time=cursor.getString(1);
                String notes =cursor.getString(2);

                Log.d("DB Values desde El CursorAdpaterCreator: ", time + " " + notes);//esto fiunciona:1625-1625/com.materiales.jrdv.ejrunning D/DB Values:﹕ 33:44 PRIMERA

            } while (cursor.moveToNext());

        }

        cursor.moveToFirst();
    }


    @Override

    //
    //THE NEWVIEW RETURNS A NEW LIST ITEM LAYOUT BUT DOES NOT CONTAINS ANY DATA YET!!!!,

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.time_list_item,parent,false);

        return view;

    }

    //THE BINDVIEW METHOD KNOW HOW TO TAKE AN EXISTING LAYOUT AND UPDATE IT WITH THE DATA POINTED BY THE CURSOR,POR LO QUE EN ESTE METODO HACEMOS UN BIND DE LOS DATOS DEL CURSOR  A LAS VIEWS!!!!
    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        //obtenemos una referencia a la textview

        TextView timeTextView = (TextView) view.findViewById(R.id.time_view);

        //pero ahora le damos el valor desde el cursor y no dese la position del arraylist

       // timeTextView.setText(cursor.getString(cursor.getColumnIndex(1)));

        timeTextView.setText(cursor.getString(1));

        //e idem con las notes

        TextView notesTextView=(TextView)view.findViewById(R.id.notes_view);

        //notesTextView.setText(cursor.getString(cursor.getColumnIndex(2)));

        notesTextView.setText(cursor.getString(2));

    }
}
