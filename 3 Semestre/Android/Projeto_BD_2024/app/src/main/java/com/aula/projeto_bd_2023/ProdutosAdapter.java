package com.aula.projeto_bd_2023;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ProdutosAdapter extends ArrayAdapter<ModeloDadosProd> {

    private Context context;
    private List<ModeloDadosProd> listaProdutos = null;

    public ProdutosAdapter(Context context, List<ModeloDadosProd> listaProdutos) {
        super(context, 0, listaProdutos);
        this.listaProdutos = listaProdutos;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        ModeloDadosProd produtos =  listaProdutos.get(position);

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_item_prod, null);
        }

        TextView txtCONPRODId = (TextView) view.findViewById(R.id.txtCONPRODId);
        TextView txtCONPRODCodBarras = (TextView) view.findViewById(R.id.txtCONPRODCodBarras);
        TextView txtCONSPRODNome = (TextView)  view.findViewById(R.id.txtCONPRODNome);
        TextView txtCONPRODQuantidade = (TextView)  view.findViewById(R.id.txtCONPRODQuantidade);
        TextView txtCONPRODPreco = (TextView) view.findViewById(R.id.txtCONPRODPreco);
        TextView txtCONPRODFornecedor = (TextView)  view.findViewById(R.id.txtCONPRODFornecedor);

        txtCONPRODId.setText(String.valueOf(produtos.getId()));
        txtCONPRODCodBarras.setText(String.valueOf(produtos.getCodBarras()));
        txtCONSPRODNome.setText(String.valueOf(produtos.getNome()));
        txtCONPRODQuantidade.setText(String.valueOf(produtos.getQuantidade()));
        txtCONPRODPreco.setText(String.valueOf(produtos.getPreco()));
        txtCONPRODFornecedor.setText(String.valueOf(produtos.getFornecedor()));

        return view;
    }

}