package com.aula.projeto_bd_2023;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button btSalvar, btConsultar, btAlterar, btExcluir;
    EditText codigo, nome, email;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codigo = (EditText) findViewById(R.id.txtCodigo);
        nome = (EditText) findViewById(R.id.txtNome);
        email = (EditText) findViewById(R.id.txtEmail);

        btSalvar = (Button) findViewById(R.id.btSalvar);
        btConsultar = (Button) findViewById(R.id.btConsultar);
        btAlterar = (Button) findViewById(R.id.btAlterar);
        btExcluir = (Button) findViewById(R.id.btExcluir);

        btSalvar.setOnClickListener(this);
        btConsultar.setOnClickListener(this);
        btAlterar.setOnClickListener(this);
        btExcluir.setOnClickListener(this);


    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v.getId() == R.id.btSalvar) {
            salvar();
        }

        if (v.getId() == R.id.btConsultar) {
            consultar();
        }

        if (v.getId() == R.id.btAlterar) {
            alterar();
        }

        if (v.getId() == R.id.btExcluir) {
            excluir();
        }
    }

    private void consultar() {
        int txtCodigo = Integer.parseInt(codigo.getText().toString());

        BancoController bd = new BancoController(getBaseContext());

        Cursor dados = bd.carregaDadosPeloCodigo(txtCodigo) ;

        if(dados.moveToFirst()){
            nome.setText( dados.getString(1) );
            email.setText( dados.getString(2) );
        }else{
            String msg= "Código não cadastrado";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            limpar();
        }

    }

    public void salvar() {
        String msg = "";
        String txtNome = nome.getText().toString();
        String txtEmail = email.getText().toString();

        if (txtNome.length()==0 || txtEmail.length()<10)
        {
            msg = "Atenção - Os campos Nome e E-mail devem ser preenchidos!!!";
            Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
        }else {
            BancoController bd = new BancoController(getBaseContext());
            String resultado;

            resultado = bd.insereDados(txtNome, txtEmail);

            Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            limpar();
        }

    }


    public void alterar() {
        int id = 0;
        String txtNome  = nome.getText().toString() ;
        String txtEmail = email.getText().toString() ;
        String msg = "";
        boolean erro = false;
        if (codigo.getText().toString().length()==0)
        {
            msg="Preencha o campo ID para alterar os dados";
            Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
            erro = true;
        }else{
            id = Integer.parseInt(codigo.getText().toString());
        }
        if (txtNome.length()==0)
        {
            msg="Preencha corretamente o campo Nome";
            Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
            erro = true;
        }
        if (txtEmail.length()<10){
            msg="Preencha corretamente o campo E-mail";
            Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
            erro = true;
        }
        if (erro==false){
            BancoController bd = new BancoController(getBaseContext());
            msg = bd.alteraDados(id, txtNome, txtEmail ) ;
            Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
            limpar();
        }
    }


    public void excluir() {
        int id = Integer.parseInt(codigo.getText().toString());

        BancoController bd = new BancoController(getBaseContext());

        String res ;
        res = bd.excluirDados(id) ;

        Toast.makeText(getApplicationContext(), res,Toast.LENGTH_LONG).show() ;
        limpar() ;
    }

    public void limpar(){
        codigo.setText("") ;
        nome.setText("") ;
        email.setText("") ;

    }
}