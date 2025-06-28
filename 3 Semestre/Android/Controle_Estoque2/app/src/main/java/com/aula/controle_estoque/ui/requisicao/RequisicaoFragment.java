package com.aula.controle_estoque.ui.requisicao;

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

import com.aula.controle_estoque.BancoController;
import com.aula.controle_estoque.ModeloDadosRequisicao;
import com.aula.controle_estoque.R;
import com.aula.controle_estoque.RequisicaoAdapter;

import java.util.ArrayList;
import java.util.List;

public class RequisicaoFragment extends Fragment implements View.OnClickListener {

    EditText etxtDataRequisicao, etxtHoraRequisicao, etxtCodRequisicao, etxtReqRequisicao, etxtQuantRequisicao, etxtTotalRequisicao;
    Button btAddProdRequisicao, btEnviarRequisicao;
    ListView listaRequisicao;
    float totalRequisicao = 0;
    List<ModeloDadosRequisicao> listaRequisicoes;
    RequisicaoAdapter requisicaoAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_requisicao, container, false);

        // Inicializar os componentes da interface do usuário
        etxtDataRequisicao = view.findViewById(R.id.etxtDataRequisicao);
        etxtHoraRequisicao = view.findViewById(R.id.etxtHoraRequisicao);
        etxtCodRequisicao = view.findViewById(R.id.etxtCodRequisicao);
        etxtReqRequisicao = view.findViewById(R.id.etxtReqRequisicao);
        etxtQuantRequisicao = view.findViewById(R.id.etxtQuantRequisicao);
        etxtTotalRequisicao = view.findViewById(R.id.etxtTotalRequisicao);
        btAddProdRequisicao = view.findViewById(R.id.btAddProdRequisicao);
        btEnviarRequisicao = view.findViewById(R.id.btEnviarRequisicao);
        listaRequisicao = view.findViewById(R.id.listaRequisicao);

        // Inicializar a lista e o adaptador
        listaRequisicoes = new ArrayList<>();
        requisicaoAdapter = new RequisicaoAdapter(getContext(), listaRequisicoes);
        listaRequisicao.setAdapter(requisicaoAdapter);

        // Adicionar listener de clique aos botões
        btAddProdRequisicao.setOnClickListener(this);
        btEnviarRequisicao.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btAddProdRequisicao) {
            // Adicionar produto à lista
                adicionarProdutoLista();
        } else if (view.getId() == R.id.btEnviarRequisicao) {
            // Enviar requisição
            enviarRequisicao();
        }
    }

    public void adicionarProdutoLista() {
        // Obter dados do produto
        String data = etxtDataRequisicao.getText().toString();
        String hora = etxtHoraRequisicao.getText().toString();
        String codBarras = etxtCodRequisicao.getText().toString();
        String quantidadeStr = etxtQuantRequisicao.getText().toString();
        String requisitante = etxtReqRequisicao.getText().toString();

        // Verificar se os campos obrigatórios estão preenchidos
        if (data.isEmpty() || hora.isEmpty() || codBarras.isEmpty() || quantidadeStr.isEmpty() || requisitante.isEmpty()) {
            Toast.makeText(getContext(), "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verificar se o código de barras está cadastrado
        BancoController bancoController = new BancoController(getContext());
        if (!bancoController.verificarSeExiste(codBarras)) {
            Toast.makeText(getContext(), "Código de barras não cadastrado", Toast.LENGTH_SHORT).show();
            return;
        }

        // Converter a quantidade para inteiro
        int quantidade;
        try {
            quantidade = Integer.parseInt(quantidadeStr);
        } catch (NumberFormatException e) {
            // Tratar o caso em que a quantidade não é um número válido
            Toast.makeText(getContext(), "A quantidade deve ser um número válido", Toast.LENGTH_SHORT).show();
            return;
        }

        // Obter nome e preço do produto do banco de dados
        String nomeProduto = bancoController.NomeProduto(codBarras);
        float valorProduto = bancoController.PrecoProduto(codBarras);

        // Calcular o total parcial do produto
        float totalParcial = quantidade * valorProduto;

        // Atualizar o total da requisição
        totalRequisicao += totalParcial;

        // Formatar o valor para duas casas decimais
        String totalRequisicaoFormatado = String.format("%.2f", totalRequisicao);

        etxtTotalRequisicao.setText(String.valueOf(totalRequisicaoFormatado));

        // Criar um novo objeto ModeloDadosRequisicao
        ModeloDadosRequisicao requisicao = new ModeloDadosRequisicao();
        requisicao.setData(data);
        requisicao.setHora(hora);
        requisicao.setCodBarras(codBarras);
        requisicao.setNomeProduto(nomeProduto);
        requisicao.setQuantidade(quantidade);
        requisicao.setRequisitante(requisitante);
        requisicao.setValorRequisicao(valorProduto);
        requisicao.setTotalParcial(totalParcial);

        // Adicionar o objeto à lista
        listaRequisicoes.add(requisicao);

        // Notificar o adaptador sobre a mudança nos dados
        requisicaoAdapter.notifyDataSetChanged();
    }


    public void enviarRequisicao() {
        String data = etxtDataRequisicao.getText().toString();
        String hora = etxtHoraRequisicao.getText().toString();
        String codBarras = etxtCodRequisicao.getText().toString();
        String quantidade = etxtQuantRequisicao.getText().toString();
        String valorRequisicao = etxtTotalRequisicao.getText().toString();
        String requisitante = etxtReqRequisicao.getText().toString();

        // Verificar se todos os campos estão preenchidos
        if (data.isEmpty() || hora.isEmpty() || codBarras.isEmpty() || quantidade.isEmpty() || valorRequisicao.isEmpty() || requisitante.isEmpty()) {
            Toast.makeText(getContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Chamar o método insereDadosRequisicao para inserir a requisição no banco de dados
        BancoController bancoController = new BancoController(getContext());
        String resultado = bancoController.insereDadosRequisicao(data, hora, codBarras, quantidade, valorRequisicao, requisitante);

        // Exibir mensagem de resultado
        Toast.makeText(getContext(), resultado, Toast.LENGTH_SHORT).show();

        // Limpar os campos após inserção
        limparCampos();

        // Limpar a lista após inserção
        listaRequisicoes.clear();
        requisicaoAdapter.notifyDataSetChanged();
    }

    public void limparCampos() {
        etxtDataRequisicao.setText("");
        etxtHoraRequisicao.setText("");
        etxtCodRequisicao.setText("");
        etxtQuantRequisicao.setText("");
        etxtReqRequisicao.setText("");
        etxtTotalRequisicao.setText("");
    }
}
