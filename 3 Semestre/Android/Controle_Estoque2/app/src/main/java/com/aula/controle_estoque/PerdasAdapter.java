package com.aula.controle_estoque;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PerdasAdapter extends BaseAdapter {
    private Context context;
    private List<ModeloDadosPerdas> listaPerdas;

    public PerdasAdapter(Context context, List<ModeloDadosPerdas> listaPerdas) {
        this.context = context;
        this.listaPerdas = listaPerdas;
    }

    @Override
    public int getCount() {
        return listaPerdas.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPerdas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_item_perda, parent, false);
        }

        ModeloDadosPerdas perda = listaPerdas.get(position);

        TextView txtData = convertView.findViewById(R.id.txtData);
        TextView txtHora = convertView.findViewById(R.id.txtHora);
        TextView txtCodBarras = convertView.findViewById(R.id.txtCodBarras);
        TextView txtNomeProduto = convertView.findViewById(R.id.txtNomeProduto);
        TextView txtQuantidade = convertView.findViewById(R.id.txtQuantidade);
        TextView txtTotalParcial = convertView.findViewById(R.id.txtTotalParcial);

        txtData.setText(perda.getData());
        txtHora.setText(perda.getHora());
        txtCodBarras.setText(perda.getCodBarras());
        txtNomeProduto.setText(perda.getNomeProduto());
        txtQuantidade.setText(String.valueOf(perda.getQuantidade()));
        txtTotalParcial.setText(String.format("%.2f", perda.getTotalParcial()));

        return convertView;
    }
}
