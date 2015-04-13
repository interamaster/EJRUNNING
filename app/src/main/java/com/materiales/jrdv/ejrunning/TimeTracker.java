package com.materiales.jrdv.ejrunning;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class TimeTracker extends ActionBarActivity {

    //este REQUEST_CODE es el que se le devuleve al metodo onActivityResult si se llamo desde StartActivityforResult!!

    public static final int TIME_ENTRY_REQUEST_CODE=1;



    //creamos una ivar del ADAPTER

    TimeTrackerAdapter timeTrackerAdapter;


    //y otra para acceder al dbhelper

    private TimeTrackerDatabaseHelper databaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);

        //Aqui obtenemos una referencia  a la LISTVIEW:

        ListView listView=(ListView) findViewById(R.id.times_list);

        //instanciamos el adapter

       timeTrackerAdapter =new TimeTrackerAdapter();

        //configurams la listView para usar el Adapter

        listView.setAdapter(timeTrackerAdapter);

        //VAMOS A INSTANCIAR NUESTRO OPENHELPER DEL SQL Y ASI SE CREARA LA DATABASE automaticamente!!!

        //TimeTrackerOpenHelper openHelper= new TimeTrackerOpenHelper(this);
        //ahora lo hacemos conla class dbhelper nueva

        databaseHelper=new TimeTrackerDatabaseHelper(this);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //chequeamos que el request code es el que nosotros enviamos..para asegurarnos que volvemos de la activity que
        //iniciamos con el startActivityForResult(intent,TIME_ENTRY_REQUEST_CODE);

        if (requestCode==TIME_ENTRY_REQUEST_CODE){

            //y luego nos asegurmaos qee resultado fue ok, lo cual solo sucedera al darle al boton SAVE, el cancel como
            //no le dijimos nada pues no se ejecutara esto
            if (resultCode== RESULT_OK){

                //obtenmos del string los valores (con los key /values del AddTimeActivity

                String notes=data.getStringExtra("notes");
                String time=data.getStringExtra("time");


                //aqui ya podemos Guardarla en el SQL:

                databaseHelper.saveTimerecord(time,notes);


                //Creamos u nevo TimeRecord Object y lo añadimos l arrayList

                TimeRecord timeRecordPasadoDelIntent=new TimeRecord(time,notes);

                //añadimos el nuevo TimeRecord Object al Adapter

                timeTrackerAdapter.addTimeRecord(timeRecordPasadoDelIntent);



                //con esto actualizamos el ListView:

                timeTrackerAdapter.notifyDataSetChanged();

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.actions_add) {

            //si se elige ADD:

            //presentamos por medio de u intent el AddTimeActivity:

            Intent intent = new Intent(this,AddTimeActivity.class);
            //Asi no se espera que el intent le devuleva nada:
            //startActivity(intent);
            //si queremos que el intente cuando se acabe la otra activty nos devuuelva algo
            //se inicia con startActivityForResult y asi nos llamara al metodo onActivityResult aqui
            //y ademas nos devolvera algun dato CUANDO ACABE LA OTRA ACTIVITY LLMADA DESDE AQUI

            startActivityForResult(intent,TIME_ENTRY_REQUEST_CODE);



            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
