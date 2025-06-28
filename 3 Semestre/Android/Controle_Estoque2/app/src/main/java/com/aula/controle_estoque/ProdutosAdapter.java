package com.aula.controle_estoque;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ProdutosAdapter extends ArrayAdapter<ModeloDadosProd> {

    public ProdutosAdapter(@NonNull Context context, @NonNull List<ModeloDadosProd> listaProdutos) {
        super(context, 0, listaProdutos);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_item_prod,
                    parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txtCONSPRODNome = convertView.findViewById(R.id.txtCONPRODNome);
            viewHolder.txtCONPRODPreco = convertView.findViewById(R.id.txtCONPRODPreco);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ModeloDadosProd produtos = getItem(position);

        if (produtos != null) {
            viewHolder.txtCONSPRODNome.setText(String.valueOf(produtos.getNome()));
            viewHolder.txtCONPRODPreco.setText(String.valueOf(produtos.getPreco()));
        }
        return convertView;
    }
    private static class ViewHolder {

        TextView txtCONSPRODNome;
        TextView txtCONPRODPreco;
    }
}