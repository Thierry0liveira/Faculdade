package com.aula.aula07_n1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DatePicker dpData;
    TimePicker pTime;
    Button btMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btMostrar = (Button) findViewById(R.id.btMostrar);
        dpData = (DatePicker) findViewById(R.id.dpData);
        pTime = (TimePicker) findViewById(R.id.pTime);

        btMostrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setMessage("Data Selecionada: " + dpData.getDayOfMonth() + "/" + (dpData.getMonth()+1 )+"/" + dpData.getYear());
        dialogo.setMessage("e Hora Selecionada: " + pTime.getHour() + ":" + pTime.getMinute());
        dialogo.setTitle("Atenção");
        dialogo.setNeutralButton("OK", null);
        dialogo.show();
    }
}