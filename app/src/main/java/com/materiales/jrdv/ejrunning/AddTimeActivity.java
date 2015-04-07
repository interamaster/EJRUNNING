package com.materiales.jrdv.ejrunning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class AddTimeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_time);
    }


    public void  onCancel (View view){

        finish();
    }


    public  void onSave (View view){

        Intent intent=getIntent();

        //tomamos referenia ala edittextVIew
        EditText timeView=(EditText)findViewById(R.id.time_view_edittext);

        //añadimos(put) al intent el key value pair con el key=time y el value= valor del EdittextView
        intent.putExtra("time",timeView.getText().toString());

        //e idem con el otro

        EditText notesView=(EditText)findViewById(R.id.notes_view_edittext);

        intent.putExtra("notes",notesView.getText().toString());


        //y ahora a nuestra activity le decimos que pase el intent

        this.setResult(RESULT_OK,intent);

        //y cerraqmos esta activity

        finish();
        // y de aqui llmaara al metodo onActivityResult con el resultado de OK y con el intent con los datos (en la activity que lo llamo
        //osea en TimeTracker




    }
}
