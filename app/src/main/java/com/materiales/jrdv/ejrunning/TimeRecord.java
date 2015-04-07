package com.materiales.jrdv.ejrunning;

/**
 * Created by invitado on 04/04/15.
 *
 * esta la class para el objeto TimeRecord
 */
public class TimeRecord {

    //las ivars

    private String time;
    private String notes;


//el constructor

    public TimeRecord(String time, String notes) {

        this.time=time;
        this.notes=notes;


    }


    //los getter and setter

    public String getTime() {
        return time;

    }

    public void setTime(String time){

        this.time=time;

    }


    public  String getNotes(){

        return notes;

    }

    public  void  setNotes(String notes){

        this.notes=notes;

    }

}
