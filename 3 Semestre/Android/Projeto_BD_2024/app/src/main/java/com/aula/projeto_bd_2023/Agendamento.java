package com.aula.projeto_bd_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

public class Agendamento extends AppCompatActivity implements View.OnClickListener {
    String _email;
    Button btAGEAgendar;
    DatePicker txtAGEData;
    Spinner txtAGEHora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);

        Intent intencao = getIntent();
        Bundle paramertros = intencao.getExtras();
        _email = paramertros.getString("email");

        btAGEAgendar = (Button) findViewById(R.id.btAGEAgendar);
        txtAGEData = (DatePicker) findViewById(R.id.txtAGEData);
        txtAGEHora = (Spinner) findViewById(R.id.txtAGEHora);

        //definir os horarios
        String[] horarios = new String[] {"08:00", "08:30","09:00", "09:30"};

        ArrayAdapter<String> aad = new ArrayAdapter<>(this, android.R.layout.simple_gallery_item, horarios);
        txtAGEHora.setAdapter(aad);

        //quando houver o click no botão, dispara o evento Click
        btAGEAgendar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String data, hora;
        int mes = txtAGEData.getMonth()+1;
        data = txtAGEData.getDayOfMonth() + "/" + mes + "/" + txtAGEData.getYear();
        hora = txtAGEHora.getSelectedItem().toString();

        BancoController bd = new BancoController(getBaseContext());
        String resultado;

        //verificar se não há um agendamento no mesmo dia / hora
        Cursor dados = bd.consultaParaAgendar(data,hora);
        if(dados.moveToFirst()) {
            //não pode agendar
            resultado = "Atenção - Data / Hora indisponível para agendamento";
            Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        }else{
            resultado = bd.insereDadosAgendamento(data, hora, _email);
            Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        }
    }
}