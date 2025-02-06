package com.aula.solidario_net.ui.consultar;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.aula.solidario_net.BancoController;
import com.aula.solidario_net.ModeloDadosProd;
import com.aula.solidario_net.ProdutosAdapter;
import com.aula.solidario_net.R;

import java.util.LinkedList;
import java.util.List;

public class ConsultarFragment extends Fragment implements View.OnClickListener {

    EditText txtConsultarProd;
    Button btConsultarProd;
    ListView listaConsultarProdutos;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_consultar, container, false);

        //inicializar a interface
        txtConsultarProd = view.findViewById(R.id.txtConsultarProd);
        btConsultarProd = view.findViewById(R.id.btConsultarProd);
        listaConsultarProdutos = view.findViewById(R.id.listaConsultarProdutos);

        // Adicionar listener de clique ao botão
        btConsultarProd.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btConsultarProd){
            // Obter o texto do campo de consulta
            String codBarras = txtConsultarProd.getText().toString().trim();
            if (!codBarras.isEmpty()) {
                List<ModeloDadosProd> listaProdutos = consultaProdutos(codBarras);
                if (listaProdutos != null && !listaProdutos.isEmpty()) {
                    ProdutosAdapter adaptador = new ProdutosAdapter(requireContext(), listaProdutos);
                    listaConsultarProdutos.setAdapter(adaptador);
                } else {
                    Toast.makeText(requireContext(), "Não há Produtos com esse Código de Barras Cadastrado", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(requireContext(), "Por favor, insira um código de barras para consulta", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private List<ModeloDadosProd> consultaProdutos(String _codBarras) {
        List<ModeloDadosProd> lista = new LinkedList<ModeloDadosProd>();

        BancoController bd = new BancoController(getContext());
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