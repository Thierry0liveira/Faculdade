package com.aula.projeto_bd_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Pedidos extends AppCompatActivity implements View.OnClickListener {
    Button btMaisBatata, btMaisHamburger, btMaisRefrigerante;
    Button btMenosBatata, btMenosHamburger, btMenosRefrigerante;
    Button btGravarPedido;
    TextView lblQtdHamburger, lblQtdRefrigerante, lblQtdBatata, lblTotalPedido;
    String _email= "";
    int qtdHamburger=0, qtdRefrigerante=0, qtdBatata=0;
    float totalPedido =0, valorHamburger = 20, valorBatata = 10, valorRefrigerante=8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        _email = parametros.getString("email");

        btMaisBatata = (Button) findViewById(R.id.btMaisBatata);
        btMaisHamburger = (Button) findViewById(R.id.btMaisHamburger);
        btMaisRefrigerante = (Button) findViewById(R.id.btMaisRefrigerante);

        btMenosBatata = (Button) findViewById(R.id.btMenosBatata);
        btMenosHamburger = (Button) findViewById(R.id.btMenosHamburger);
        btMenosRefrigerante = (Button) findViewById(R.id.btMenosRefrigerante);

        btGravarPedido = (Button) findViewById(R.id.btGravarPedido);

        lblQtdHamburger = (TextView) findViewById(R.id.lblQtdHamburger);
        lblQtdRefrigerante = (TextView) findViewById(R.id.lblQtdRefrigerante);
        lblQtdBatata = (TextView) findViewById(R.id.lblQtdBatata);
        lblTotalPedido = (TextView) findViewById(R.id.lblTotalPedido);

        btMaisBatata.setOnClickListener(this);
        btMaisHamburger.setOnClickListener(this);
        btMaisRefrigerante.setOnClickListener(this);

        btMenosBatata.setOnClickListener(this);
        btMenosHamburger.setOnClickListener(this);
        btMenosRefrigerante.setOnClickListener(this);

        btGravarPedido.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        float totalBatata = 0, totalRefrigerante = 0, totalHamburger = 0;

        qtdBatata = Integer.parseInt(lblQtdBatata.getText().toString());
        qtdHamburger = Integer.parseInt(lblQtdHamburger.getText().toString());
        qtdRefrigerante = Integer.parseInt(lblQtdRefrigerante.getText().toString());
        if (view.getId()==R.id.btMaisBatata){
            qtdBatata++;
            lblQtdBatata.setText(""+ qtdBatata);
        }
        if (view.getId()==R.id.btMaisHamburger){
            qtdHamburger++;
            lblQtdHamburger.setText(""+ qtdHamburger);
        }
        if (view.getId()==R.id.btMaisRefrigerante){
            qtdRefrigerante++;
            lblQtdRefrigerante.setText(""+ qtdRefrigerante);
        }
        if (view.getId()==R.id.btMenosBatata){
            qtdBatata--;
            if (qtdBatata < 0){
                qtdBatata = 0;
            }
            lblQtdBatata.setText(""+ qtdBatata);
        }
        if (view.getId()==R.id.btMenosHamburger){
            qtdHamburger--;
            if (qtdHamburger < 0){
                qtdHamburger = 0;
            }
            lblQtdHamburger.setText(""+ qtdHamburger);
        }
        if (view.getId()==R.id.btMenosRefrigerante){
            qtdRefrigerante--;
            if (qtdRefrigerante < 0){
                qtdRefrigerante = 0;
            }
            lblQtdRefrigerante.setText(""+ qtdRefrigerante);
        }
        totalBatata = valorBatata * qtdBatata;    //preço * quantidade
        totalHamburger = valorHamburger * qtdHamburger;
        totalRefrigerante = valorRefrigerante * qtdRefrigerante;
        totalPedido = totalBatata + totalHamburger + totalRefrigerante;
        lblTotalPedido.setText("R$ "+ totalPedido);

        if (view.getId()==R.id.btGravarPedido){
            if (totalPedido == 0){
                String msg = "Não é possível gravar um pedido em branco";
                Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
            }else{
                GravarPedido();
            }
        }
    }
    public void GravarPedido() {
        BancoController bd = new BancoController(getBaseContext());
        String resultado;

        resultado = bd.insereDadosPedido(_email, qtdHamburger, qtdBatata, qtdRefrigerante,
                valorHamburger, valorBatata, valorRefrigerante, totalPedido);

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        Limpar();
    }
    public void Limpar(){
        lblQtdBatata.setText("0");
        lblQtdHamburger.setText("0");
        lblQtdRefrigerante.setText("0");
        lblTotalPedido.setText("R$ 0.0");
    }
}