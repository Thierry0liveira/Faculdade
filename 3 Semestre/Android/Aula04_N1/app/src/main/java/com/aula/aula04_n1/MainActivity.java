package com.aula.aula04_n1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // criando os objetos
    Button btCachorro, btGato, btRato;
    ImageView imgFigura;
    TextView lblFigura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCachorro = (Button) findViewById(R.id.btCachorro);
        btGato = (Button) findViewById(R.id.btGato);
        btRato = (Button) findViewById(R.id.btRato);
        imgFigura = (ImageView) findViewById(R.id.imgFigura);
        lblFigura = (TextView) findViewById(R.id.lblFigura);
        
        btCachorro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgFigura.setImageResource(R.drawable.cachorro);
                lblFigura.setText("Figura: Cachorro.");
            }
        });

        btGato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgFigura.setImageResource(R.drawable.gato);
                lblFigura.setText("Figura: Gato.");
            }
        });

        btRato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgFigura.setImageResource(R.drawable.rato);
                lblFigura.setText("Figura: Rato.");
            }
        });

    }
}