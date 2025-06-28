package com.aula.projeto_bd_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    TextView txtMENUser;
    ImageButton btMENContatos, btMENPedidos, btMENMeusDados, btMENAgendamento,
            btMENConsultaAgendamento, btMENCadastroProdutos, btMENConsultaProduto;
    String _email = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intencao = getIntent();
        Bundle paramertros = intencao.getExtras();
        _email = paramertros.getString("email");

        txtMENUser = (TextView) findViewById(R.id.txtMENUser);
        btMENContatos = (ImageButton) findViewById(R.id.btMENContatos);
        btMENPedidos = (ImageButton) findViewById(R.id.btMENPedidos);
        btMENMeusDados = (ImageButton) findViewById(R.id.btMENMeusDados);
        btMENAgendamento = (ImageButton) findViewById(R.id.btMENAgendamento);
        btMENConsultaAgendamento = (ImageButton) findViewById(R.id.btMENConsultaAgendamento);
        btMENCadastroProdutos = (ImageButton) findViewById(R.id.btMENCadastroProdutos);
        btMENConsultaProduto = (ImageButton) findViewById(R.id.btMENConsultaProduto);

        txtMENUser.setText("Usuário: " + _email);
        btMENContatos.setOnClickListener(this);
        btMENPedidos.setOnClickListener(this);
        btMENMeusDados.setOnClickListener(this);
        btMENAgendamento.setOnClickListener(this);
        btMENConsultaAgendamento.setOnClickListener(this);
        btMENCadastroProdutos.setOnClickListener(this);
        btMENConsultaProduto.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btMENContatos){
            Intent tela = new Intent(this, MainActivity.class);
            startActivity(tela);
        }
        if (view.getId()==R.id.btMENPedidos){
            Intent tela = new Intent(this, Pedidos.class);

            Bundle parametros = new Bundle();
            parametros.putString("email",_email);
            tela.putExtras(parametros);

            startActivity(tela);
        }
        if (view.getId()==R.id.btMENMeusDados){
            Intent tela = new Intent(this, MeusDados.class);

            Bundle parametros = new Bundle();
            parametros.putString("email",_email);
            tela.putExtras(parametros);

            startActivity(tela);
        }
        if (view.getId()==R.id.btMENAgendamento){
            Intent tela = new Intent(this, Agendamento.class);

            Bundle parametros = new Bundle();
            parametros.putString("email",_email);
            tela.putExtras(parametros);

            startActivity(tela);
        }
        if (view.getId()==R.id.btMENConsultaAgendamento){
            Intent tela = new Intent(this, SelecionaData.class);

            Bundle parametros = new Bundle();
            parametros.putString("email",_email);
            tela.putExtras(parametros);

            startActivity(tela);
        }
        if (view.getId()==R.id.btMENCadastroProdutos){
            Intent tela = new Intent(this, CadastroProdutos.class);

            Bundle parametros = new Bundle();
            parametros.putString("email",_email);
            tela.putExtras(parametros);

            startActivity(tela);
        }
        if (view.getId()==R.id.btMENConsultaProduto){
            Intent tela = new Intent(this, ConsultaProdutos.class);

            Bundle parametros = new Bundle();
            parametros.putString("email",_email);
            tela.putExtras(parametros);

            startActivity(tela);
        }
    }
}