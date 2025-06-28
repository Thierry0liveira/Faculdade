package com.aula.projeto_bd_2023;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

public class ConsultaProdutos extends AppCompatActivity implements View.OnClickListener {
    EditText txtConsultarProd;
    Button btConsultarProd;
    ListView listaConsultarProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consulta_produtos);

        //inicializar a interface
        txtConsultarProd = (EditText) findViewById(R.id.txtConsultarProd);
        btConsultarProd = (Button) findViewById(R.id.btConsultarProd);
        listaConsultarProdutos = findViewById(R.id.listaConsultarProdutos);

        // Adicionar listener de clique ao botão
        btConsultarProd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btConsultarProd){
            // Obter o texto do campo de consulta
            String codBarras = txtConsultarProd.getText().toString().trim();
            if (!codBarras.isEmpty()) {
                List<ModeloDadosProd> listaProdutos = consultaProdutos(codBarras);
                if (listaProdutos != null && !listaProdutos.isEmpty()) {
                    ProdutosAdapter adaptador = new ProdutosAdapter(this, listaProdutos);
                    listaConsultarProdutos.setAdapter(adaptador);
                } else {
                    Toast.makeText(this, "Não há Produtos com esse Código de Barras Cadastrado", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Por favor, insira um código de barras para consulta", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private List<ModeloDadosProd> consultaProdutos(String _codBarras) {
        List<ModeloDadosProd> lista = new LinkedList<ModeloDadosProd>();

        BancoController bd = new BancoController(getBaseContext());
        Cursor dados = bd.ConsultarProdutos(_codBarras);

        if (dados.moveToFirst()){
            // se encontrou dados na tabela de produtos
            do {
                ModeloDadosProd item = new ModeloDadosProd();
                item.setId(dados.getInt(0));
                item.setCodBarras(dados.getString(1));
                item.setNome(dados.getString(2));
                item.setQuantidade(dados.getInt(3));
                item.setPreco(dados.getFloat(4));
                item.setFornecedor(dados.getString(5));
                lista.add(item);
            } while (dados.moveToNext());
        }

        if (dados != null) {
            dados.close();
        }

        return lista;
    }
}