package com.materiales.jrdv.ejrunning;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by invitado on 04/04/15.
 *
 * este es el adapter de la listview
 */
public class TimeTrackerAdapter  extends BaseAdapter{

    //añadimos un arraylist para guardar los TimeRecords objects como una ivar
    private ArrayList<TimeRecord>times =new ArrayList<TimeRecord>();



//vamos a rellenar con dummy data el ArrayList:

    public TimeTrackerAdapter(){
        times.add(new TimeRecord("38.23","Feeling OK now"));

        times.add(new TimeRecord("23.23","Feeling bad very bad"));

        times.add(new TimeRecord("38.55","Feeling tired of writting this shit"));

        times.add(new TimeRecord("12.23","Feeling OK now"));

    }

    //creo un nevo emtodo para oder añadir TimeRecords:



    public void  addTimeRecord(TimeRecord timeRecord){

        times.add(timeRecord);


    }





    @Override
    public int getCount() {
        return times.size();

    }

    @Override
    public Object getItem(int position) {

        //gracias a extends el BaseAdapter el solo se encara de coger el position que coinicida con el Adapter
        return getItem(position);

    }

    @Override
    public long getItemId(int position) {
        //gracias a extends el BaseAdapter el solo se encara de coger el position que coinicida con el Adapter
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //necesitamos crear una custom view!!que se llama "time_list_item"

         if (convertView == null){
             //si es null la sacamos con el inflater

             LayoutInflater inflater=LayoutInflater.from(parent.getContext());
             convertView=inflater.inflate(R.layout.time_list_item,parent,false);

         }

        TimeRecord time=times.get(position);//the TimeRecord del ArrayList en esa position tine la info

        TextView timeTextView = (TextView) convertView.findViewById(R.id.time_view);//obtenemos una referencia a la textview

        timeTextView.setText(time.getTime());//le pasamos el text del TimeRecord object (time) que coinicide en el ArrayList con nuestra positiom


        //e idem con las notes

        TextView notesTextView=(TextView)convertView.findViewById(R.id.notes_view);
        notesTextView.setText(time.getNotes());


        return convertView;





    }
}
