package com.aula.controle_estoque.ui.perdas;

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
import com.aula.controle_estoque.ModeloDadosPerdas;
import com.aula.controle_estoque.R;
import com.aula.controle_estoque.PerdasAdapter;

import java.util.ArrayList;
import java.util.List;

public class PerdasFragment extends Fragment implements View.OnClickListener {

    EditText etxtDataPerdas, etxtHoraPerdas, etxtCodBarrasPerdas, etxtQuantPerdas, etxtTotalPerdas;
    Button btAddProdPerdas, btEnviarPerdas;
    ListView listaPerdas;
    float totalPerdas = 0;
    List<ModeloDadosPerdas> listaPerdasData;
    PerdasAdapter perdasAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perdas, container, false);

        // Inicializar os componentes da interface do usuário
        etxtDataPerdas = view.findViewById(R.id.etxtDataPerdas);
        etxtHoraPerdas = view.findViewById(R.id.etxtHoraPerdas);
        etxtCodBarrasPerdas = view.findViewById(R.id.etxtCodBarrasPerdas);
        etxtQuantPerdas = view.findViewById(R.id.etxtQuantPerdas);
        etxtTotalPerdas = view.findViewById(R.id.etxtTotalPerdas);
        btAddProdPerdas = view.findViewById(R.id.btAddProdPerdas);
        btEnviarPerdas = view.findViewById(R.id.btEnviarPerdas);
        listaPerdas = view.findViewById(R.id.listaPerdas);

        // Inicializar a lista e o adaptador
        listaPerdasData = new ArrayList<>();
        perdasAdapter = new PerdasAdapter(getContext(), listaPerdasData);
        listaPerdas.setAdapter(perdasAdapter);

        // Adicionar listener de clique aos botões
        btAddProdPerdas.setOnClickListener(this);
        btEnviarPerdas.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btAddProdPerdas) {
            // Adicionar produto à lista de perdas
            adicionarProdutoLista();
        } else if (view.getId() == R.id.btEnviarPerdas) {
            // Enviar perdas
            enviarPerdas();
        }
    }
    public void adicionarProdutoLista() {
        // Obter dados do produto
        String data = etxtDataPerdas.getText().toString();
        String hora = etxtHoraPerdas.getText().toString();
        String codBarras = etxtCodBarrasPerdas.getText().toString();
        String quantidadeStr = etxtQuantPerdas.getText().toString();

        // Verificar se os campos obrigatórios estão preenchidos
        if (data.isEmpty() || hora.isEmpty() || codBarras.isEmpty() || quantidadeStr.isEmpty()) {
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

        // Atualizar o total das perdas
        totalPerdas += totalParcial;
        etxtTotalPerdas.setText(String.valueOf(totalPerdas));

        // Criar um novo objeto ModeloDadosPerdas
        ModeloDadosPerdas perda = new ModeloDadosPerdas();
        perda.setData(data);
        perda.setHora(hora);
        perda.setCodBarras(codBarras);
        perda.setNomeProduto(nomeProduto);
        perda.setQuantidade(quantidade);
        perda.setValorPerda(valorProduto);
        perda.setTotalParcial(totalParcial);

        // Adicionar o objeto à lista
        listaPerdasData.add(perda);

        // Notificar o adaptador sobre a mudança nos dados
        perdasAdapter.notifyDataSetChanged();
    }

    public void enviarPerdas() {
        String data = etxtDataPerdas.getText().toString();
        String hora = etxtHoraPerdas.getText().toString();
        String codBarras = etxtCodBarrasPerdas.getText().toString();
        String quantidade = etxtQuantPerdas.getText().toString();
        String valorPerda = etxtTotalPerdas.getText().toString();

        // Verificar se todos os campos estão preenchidos
        if (data.isEmpty() || hora.isEmpty() || codBarras.isEmpty() || quantidade.isEmpty() || valorPerda.isEmpty()) {
            Toast.makeText(getContext(), "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Chamar o método insereDadosPerda para inserir a perda no banco de dados
        BancoController bancoController = new BancoController(getContext());
        String resultado = bancoController.insereDadosPerda(data, hora, codBarras, quantidade, valorPerda);

        // Exibir mensagem de resultado
        Toast.makeText(getContext(), resultado, Toast.LENGTH_SHORT).show();

        // Limpar os campos após inserção
        limparCampos();
        limparLista();
    }

    public void limparCampos() {
        etxtDataPerdas.setText("");
        etxtHoraPerdas.setText("");
        etxtCodBarrasPerdas.setText("");
        etxtQuantPerdas.setText("");
        etxtTotalPerdas.setText("");
    }

    public void limparLista() {
        listaPerdasData.clear();
        perdasAdapter.notifyDataSetChanged();
        totalPerdas = 0;
    }
}
