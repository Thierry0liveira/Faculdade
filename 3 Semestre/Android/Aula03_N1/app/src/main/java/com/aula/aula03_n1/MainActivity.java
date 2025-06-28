package com.aula.aula03_n1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btAdicionar;
    EditText txtN1, txtN2, txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAdicionar = (Button) findViewById(R.id.btAdicionar);
        txtN1 = (EditText) findViewById(R.id.txtN1);
        txtN2 = (EditText) findViewById(R.id.txtN2);
        txtRes = (EditText) findViewById(R.id.txtRes);

        btAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1 = 0, n2 = 0, res= 0;
                n1 = Integer.parseInt(txtN1.getText().toString());
                n2 = Integer.parseInt(txtN2.getText().toString());
                res = n1 + n2;
                txtRes.setText("Somatório: " + res);
            }
        });
    }
}