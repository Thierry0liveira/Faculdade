package com.aula.aula05_n1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btTela2;
    ImageButton btTela3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btTela2 = (Button) findViewById(R.id.btTela2);
        btTela3 = (ImageButton) findViewById(R.id.btTela3);

        //quando clicar no botão ele manda pro implements onclicklistener abaixo
        btTela2.setOnClickListener(this);
        btTela3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //se a origem do clik foi o botão btTela2
        if (v.getId() == R.id.btTela2){
            //carregando a Tela2
            Intent tela2 = new Intent(this, Tela2.class);
            startActivity(tela2);
        }
        //se a origem do clik foi o botão btTela3
        if (v.getId() == R.id.btTela3){
            //carregando a Tela2
            Intent tela3 = new Intent(this, Tela3.class);
            startActivity(tela3);
    }
}}