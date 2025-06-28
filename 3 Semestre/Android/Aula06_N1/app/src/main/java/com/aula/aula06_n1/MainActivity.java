package com.aula.aula06_n1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox ckADS, ckSI, ckEng;
    RadioButton rdProgramacao, rdInfra, rdSeguranca;
    Button btVerificar;
    TextView txtSelecionados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ckADS = (CheckBox) findViewById(R.id.ckADS);
        ckSI = (CheckBox) findViewById(R.id.ckSI);
        ckEng = (CheckBox) findViewById(R.id.ckEng);

        rdProgramacao = (RadioButton) findViewById(R.id.rdProgramacao);
        rdInfra = (RadioButton) findViewById(R.id.rdInfra);
        rdSeguranca = (RadioButton) findViewById(R.id.rdSeguranca);

        btVerificar = (Button) findViewById(R.id.btVerificar);
        txtSelecionados = (TextView) findViewById(R.id.txtSelecionados);

        btVerificar.setOnClickListener(this); //Ao clicar no botão, executa o OnClick
    }

    @Override
    public void onClick(View v) {
        String opcoes = "Opções Selecionadas: ";
        if (ckADS.isChecked()){ opcoes += " - Análise e Desenvolvimento de Sistemas"; }
        if (ckSI.isChecked()){ opcoes += " - Sistemas de Informação"; }
        if (ckEng.isChecked()){ opcoes += " - Engenharia da Computação"; }
        if (rdProgramacao.isChecked()){ opcoes += " - Programação"; }
        if (rdInfra.isChecked()){ opcoes += " - Infraestrutura"; }
        if (rdSeguranca.isChecked()){ opcoes += " - Segurança"; }
        txtSelecionados.setText(opcoes);
    }
}