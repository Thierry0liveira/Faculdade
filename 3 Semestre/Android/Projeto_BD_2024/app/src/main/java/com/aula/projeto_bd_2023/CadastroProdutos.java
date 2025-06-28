package com.aula.projeto_bd_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroProdutos extends AppCompatActivity implements View.OnClickListener {
    EditText txtCADPRODCodBarras, txtCADPRODNome, txtCADPRODQtd, txtCADPRODPreco, txtCADPRODFornecedor;
    Button btCADPRODGravar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produtos);

        txtCADPRODCodBarras = (EditText) findViewById(R.id.txtCADPRODCodBarras);
        txtCADPRODNome = (EditText) findViewById(R.id.txtCADPRODNome);
        txtCADPRODQtd = (EditText) findViewById(R.id.txtCADPRODQtd);
        txtCADPRODPreco = (EditText) findViewById(R.id.txtCADPRODPreco);
        txtCADPRODFornecedor = (EditText) findViewById(R.id.txtCADPRODFornecedor);
        btCADPRODGravar = (Button) findViewById(R.id.btCADPRODGravar);

        btCADPRODGravar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (validaDados()) {
            // Gravar dados
            SalvarDados();
        }
    }

    public boolean validaDados() {
        boolean retorno = true;
        String msg = "";

        if (txtCADPRODCodBarras.getText().length() == 0) {
            msg = "O campo CÓDIGO DE BARRAS deve ser preenchido";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (txtCADPRODNome.getText().length() == 0) {
            msg = "O campo NOME DO PRODUTO deve ser preenchido";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (txtCADPRODQtd.getText().length() == 0) {
            msg = "O campo QUANTIDADE deve ser preenchido";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (txtCADPRODPreco.getText().length() == 0) {
            msg = "O campo PREÇO deve ser preenchido";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }
        if (txtCADPRODFornecedor.getText().length() == 0) {
            msg = "O campo FORNECEDOR deve ser preenchido";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            retorno = false;
        }

        return retorno;
    }

    public void SalvarDados() {
        String msg = "";
        String codBarras = txtCADPRODCodBarras.getText().toString();
        String nome = txtCADPRODNome.getText().toString();
        String qtd = txtCADPRODQtd.getText().toString();
        String preco = txtCADPRODPreco.getText().toString();
        String fornecedor = txtCADPRODFornecedor.getText().toString();

        BancoController bd = new BancoController(getBaseContext());
        String resultado;

        resultado = bd.insereDadosProduto(codBarras, nome, qtd, preco, fornecedor);

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        limpar();
    }

    public void limpar() {
        txtCADPRODCodBarras.setText("");
        txtCADPRODNome.setText("");
        txtCADPRODQtd.setText("");
        txtCADPRODPreco.setText("");
        txtCADPRODFornecedor.setText("");
    }
}