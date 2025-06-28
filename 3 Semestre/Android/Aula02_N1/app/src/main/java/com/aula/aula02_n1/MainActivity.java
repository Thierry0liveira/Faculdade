package com.aula.aula02_n1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btClique;

    TextView lblNomeDigitado;

    EditText txtNome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // associação dos objetos (View e controller)
        btClique = (Button) findViewById(R.id.btClique);
        lblNomeDigitado = (TextView) findViewById(R.id.lblNomeDigitado);
        txtNome = (EditText) findViewById(R.id.txtNome);

        btClique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblNomeDigitado.setText("Nome DIgitado: " + txtNome.getText());
            }
        });

    }
}