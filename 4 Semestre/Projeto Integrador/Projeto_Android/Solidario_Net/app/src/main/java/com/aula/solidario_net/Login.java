package com.aula.solidario_net;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText txtLOGUsuario, txtLOGSenha;
    Button btLOGAcessar, btLOGCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLOGUsuario = (EditText) findViewById(R.id.txtLOGUsuario);
        txtLOGSenha = (EditText) findViewById(R.id.txtLOGSenha);
        btLOGAcessar = (Button) findViewById(R.id.btLOGAcessar);
        btLOGCadastro = (Button) findViewById(R.id.btLOGCadastro);

        btLOGAcessar.setOnClickListener(this);
        btLOGCadastro.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btLOGCadastro){
            // clicou no botão Cadastre_se
            Intent telaCadastro = new Intent(this,Cadastro.class);
            startActivity(telaCadastro);
        }
        if (view.getId() == R.id.btLOGAcessar) {
            // Se clicou no botão acessar
            if (validaDados()) {  // se digitou os dados e os dados são válidos

                // Salvando o nome do usuário em SharedPreferences
                SharedPreferences prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("nomeUsuario", txtLOGUsuario.getText().toString());
                editor.apply();

                Intent intent = new Intent(this, MenuActivity.class);
                Bundle parametros = new Bundle();
                parametros.putString("usuario", txtLOGUsuario.getText().toString());
                intent.putExtras(parametros);
                startActivity(intent);
            }
        }
    }
    public boolean validaDados() {
        boolean retorno = true;
        String msg= "";
        if (txtLOGUsuario.getText().length() == 0 ){
            msg = "O campo USUÁRIO não foi preenchido, por favor digite o seu Usuário";
            Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }else{
            if (txtLOGSenha.getText().length() == 0) {
                msg = "O campo SENHA não foi preenchido, por favor digite a Senha";
                Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
                retorno = false;
            }else{
                BancoController bd = new BancoController(getBaseContext());

                Cursor dados = bd.carregaDadosPeloUsuarioSenha(txtLOGUsuario.getText().toString() ,
                        txtLOGSenha.getText().toString()) ;

                if(dados.moveToFirst()){
                    msg = "Usuário / Senha encontrado";
                }else{
                    msg= "O Usuário ou a Senha digitada não foram encontrados, por favor cadastre-se!";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                    retorno = false;
                }
            }
        }
        return retorno;
    }
}