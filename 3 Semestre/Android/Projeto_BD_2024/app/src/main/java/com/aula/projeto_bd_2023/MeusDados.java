package com.aula.projeto_bd_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MeusDados extends AppCompatActivity implements View.OnClickListener {
    String _email;
    EditText txtMEUNome, txtMEUCpf, txtMEUEmail, txtMEUSenha1, txtMEUSenha2;
    Button btMEUAlterar;
    int idUser =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_dados);

        Intent intencao = getIntent();
        Bundle paramertros = intencao.getExtras();
        _email = paramertros.getString("email");

        txtMEUNome = (EditText) findViewById(R.id.txtMEUNome);
        txtMEUCpf = (EditText) findViewById(R.id.txtMEUCpf);
        txtMEUEmail = (EditText) findViewById(R.id.txtMEUEmail);
        txtMEUSenha1 = (EditText) findViewById(R.id.txtMEUSenha1);
        txtMEUSenha2 = (EditText) findViewById(R.id.txtMEUSenha2);
        btMEUAlterar = (Button) findViewById(R.id.btMEUAlterar);

        BancoController bd = new BancoController(getBaseContext());

        Cursor dados = bd.consultaUsuario(_email) ;

        if(dados.moveToFirst()){
            idUser = dados.getInt(0);
            txtMEUNome.setText( dados.getString(1) );
            txtMEUCpf.setText(dados.getString(2));
            txtMEUEmail.setText( dados.getString(3) );
            txtMEUSenha1.setText(dados.getString(4));
            txtMEUSenha2.setText(dados.getString(4));
        }

        btMEUAlterar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (validaDados()==true){
            // alteradados
            AlterarDados();
        }
    }

    private void AlterarDados() {
        BancoController bd = new BancoController(getBaseContext());
        String msg = bd.alteraDadosUsuario(idUser, txtMEUNome.getText().toString(),
                txtMEUCpf.getText().toString(), txtMEUEmail.getText().toString(),
                txtMEUSenha1.getText().toString()) ;
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
    }

    public boolean validaDados() {
        boolean retorno = true;
        String msg = "";
        if (txtMEUNome.getText().length()==0){
            msg = "O campo NOME deve ser preenchido";
            Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (txtMEUCpf.getText().length()==0){
            msg = "O campo CPF deve ser preenchido";
            Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (txtMEUSenha1.getText().length()==0 || txtMEUSenha2.getText().length()==0 ){
            msg = "Os campos de SENHA devem ser preenchidos";
            Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (!txtMEUSenha1.getText().toString().equals(txtMEUSenha2.getText().toString())){
            msg = "Os campos de SENHA e CONFIRMA SENHA devem ser iguais";
            Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        return retorno;
    }
}