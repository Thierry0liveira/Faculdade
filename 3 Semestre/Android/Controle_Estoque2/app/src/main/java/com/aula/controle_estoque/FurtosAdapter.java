package com.aula.controle_estoque;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Locale;

public class FurtosAdapter extends ArrayAdapter<ModeloDadosFurtos> {
    private Context context;
    private List<ModeloDadosFurtos> furtos;
    private BancoController bancoController;

    public FurtosAdapter(Context context, List<ModeloDadosFurtos> furtos) {
        super(context, 0, furtos);
        this.context = context;
        this.furtos = furtos;
        this.bancoController = new BancoController(context); // Inicialize o bancoController aqui
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ModeloDadosFurtos furto = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_item_furto, parent, false);
        }

        TextView txtFURData = convertView.findViewById(R.id.txtFURData);
        TextView txtFURHora = convertView.findViewById(R.id.txtFURHora);
        TextView txtFURCodBarras = convertView.findViewById(R.id.txtFURCodBarras);
        TextView txtFURNomeProduto = convertView.findViewById(R.id.txtFURNomeProduto);
        TextView txtFURQuant = convertView.findViewById(R.id.txtFURQuant);
        TextView txtFURAbordado = convertView.findViewById(R.id.txtFURAbordado);
        TextView txtFURTotal = convertView.findViewById(R.id.txtFURTotal);
        TextView txtFURObsFurto = convertView.findViewById(R.id.txtFURObsFurto);

        txtFURData.setText(furto.getData());
        txtFURHora.setText(furto.getHora());
        txtFURCodBarras.setText(furto.getCodBarras());
        txtFURQuant.setText(String.valueOf(furto.getQuantidade()));
        txtFURAbordado.setText(furto.isAbordado() ? "Sim" : "Não");
        txtFURTotal.setText(String.format(Locale.getDefault(), "R$ %.2f", furto.getValorTotal()));
        txtFURObsFurto.setText(furto.getObservacoes());

        // Obter o nome do produto usando o método NomeProduto
        String nomeProduto = bancoController.NomeProduto(furto.getCodBarras());
        txtFURNomeProduto.setText(nomeProduto);

        return convertView;
    }
}
