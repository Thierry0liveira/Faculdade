package com.aula.controle_estoque;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class RequisicaoAdapter extends ArrayAdapter<ModeloDadosRequisicao> {

    public RequisicaoAdapter(@NonNull Context context, @NonNull List<ModeloDadosRequisicao> listaRequisicoes) {
        super(context, 0, listaRequisicoes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_item_requi,
                    parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txtREQData = convertView.findViewById(R.id.txtREQData);
            viewHolder.txtREQHora = convertView.findViewById(R.id.txtREQHora);
            viewHolder.txtREQCodBarras = convertView.findViewById(R.id.txtREQCodBarras);
            viewHolder.txtREQNomeProduto = convertView.findViewById(R.id.txtREQNomeProduto);
            viewHolder.txtREQQuant = convertView.findViewById(R.id.txtREQQuant);
            viewHolder.txtREQTotParc = convertView.findViewById(R.id.txtREQTotParc);
            viewHolder.txtREQReq = convertView.findViewById(R.id.txtREQReq);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ModeloDadosRequisicao requisicao = getItem(position);

        if (requisicao != null) {
            viewHolder.txtREQData.setText(String.valueOf(requisicao.getData()));
            viewHolder.txtREQHora.setText(String.valueOf(requisicao.getHora()));
            viewHolder.txtREQCodBarras.setText(String.valueOf(requisicao.getCodBarras()));
            viewHolder.txtREQNomeProduto.setText(String.valueOf(requisicao.getNomeProduto()));
            viewHolder.txtREQQuant.setText(String.valueOf(requisicao.getQuantidade()));
            viewHolder.txtREQTotParc.setText(String.format("%.2f", requisicao.getTotalParcial()));
            viewHolder.txtREQReq.setText(String.valueOf(requisicao.getRequisitante()));
        }
        return convertView;
    }

    private static class ViewHolder {
        TextView txtREQData;
        TextView txtREQHora;
        TextView txtREQCodBarras;
        TextView txtREQNomeProduto;
        TextView txtREQQuant;
        TextView txtREQTotParc;
        TextView txtREQReq;
    }
}
