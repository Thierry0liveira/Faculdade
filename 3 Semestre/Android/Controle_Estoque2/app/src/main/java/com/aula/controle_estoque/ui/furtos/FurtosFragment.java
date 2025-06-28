package com.aula.controle_estoque.ui.furtos;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.aula.controle_estoque.BancoController;
import com.aula.controle_estoque.FurtosAdapter;
import com.aula.controle_estoque.ModeloDadosFurtos;
import com.aula.controle_estoque.R;
import java.util.ArrayList;
import java.util.List;


public class FurtosFragment extends Fragment implements View.OnClickListener {


    EditText etxtDataFurto, etxtHoraFurto, etxtCodBarrasFurto, etxtQuantFurto, etxtObsFurto;
    RadioButton rbtAbordado, rbtNaoAbordado;
    Button btAddFurto, btConFurto, btExcFurto;
    FurtosAdapter furtosAdapter;
    ListView furtosLista;

    // Lista de furtos
    List<ModeloDadosFurtos> listaFurtos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_furtos, container, false);

        // Inicializar componentes
        etxtDataFurto = view.findViewById(R.id.etxtDataFurto);
        etxtHoraFurto = view.findViewById(R.id.etxtHoraFurto);
        etxtCodBarrasFurto = view.findViewById(R.id.etxtCodBarrasFurto);
        etxtQuantFurto = view.findViewById(R.id.etxtQuantFurto);
        etxtObsFurto = view.findViewById(R.id.etxtObsFurto);
        rbtAbordado = view.findViewById(R.id.rbtAbordado);
        rbtNaoAbordado = view.findViewById(R.id.rbtNaoAbordado);
        btAddFurto = view.findViewById(R.id.btAddFurto);
        btConFurto = view.findViewById(R.id.btConFurto);
        btExcFurto = view.findViewById(R.id.btExcFurto);
        furtosLista = view.findViewById(R.id.furtosLista);

        // Inicializar a lista e o adaptador
        listaFurtos = new ArrayList<>();
        furtosAdapter = new FurtosAdapter(getContext(), listaFurtos);
        furtosLista.setAdapter(furtosAdapter);

        // Configurar o botão "Registrar Furto"
        btAddFurto.setOnClickListener(this);
        btConFurto.setOnClickListener(this);
        btExcFurto.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btAddFurto) {
            registrarFurto();
        }
        if (v.getId() == R.id.btConFurto) {
            consultarFurto();
        }

        if (v.getId() == R.id.btExcFurto) {
            excluirFurto();
        }
    }

    private void registrarFurto() {
        // Obtenha os dados inseridos nos campos de entrada de texto
        String data = etxtDataFurto.getText().toString();
        String hora = etxtHoraFurto.getText().toString();
        String codBarras = etxtCodBarrasFurto.getText().toString();
        String quantidadeStr = etxtQuantFurto.getText().toString();
        boolean abordado = rbtAbordado.isChecked();
        String observacoes = etxtObsFurto.getText().toString();

        // Verifique se os campos de entrada de texto não estão vazios
        if (data.isEmpty() || hora.isEmpty() || codBarras.isEmpty() || quantidadeStr.isEmpty() || observacoes.isEmpty()) {
            // Se algum campo estiver vazio, exiba uma mensagem para o usuário
            Toast.makeText(getContext(), "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Converta a quantidade fornecida para um número inteiro
        int quantidade;
        try {
            // Tenta converter a entrada de texto para um número inteiro
            quantidade = Integer.parseInt(etxtQuantFurto.getText().toString());
        } catch (NumberFormatException e) {
            // Se a entrada não puder ser convertida para um número inteiro, exiba uma mensagem de erro e retorne
            Toast.makeText(getContext(), "Quantidade inválida", Toast.LENGTH_SHORT).show();
            return;
        }

        // Calcule o preço do produto com base no código de barras
        BancoController bancoController = new BancoController(getContext());
        float preco = bancoController.PrecoProduto(codBarras);
        if (preco == -1) {
            // Se o preço do produto não puder ser obtido, exiba uma mensagem de erro
            Toast.makeText(getContext(), "Código de barras inválido", Toast.LENGTH_SHORT).show();
            return;
        }

        // Calcula o valor total multiplicando a quantidade pelo preço
        float valorTotal = quantidade * preco;

        // Crie um objeto ModeloDadosFurtos com os dados inseridos e o valor total calculado
        ModeloDadosFurtos furto = new ModeloDadosFurtos(data, hora, codBarras, quantidade, abordado, observacoes, valorTotal);


        // Adicionar o furto à lista
        listaFurtos.add(furto);
        furtosAdapter.notifyDataSetChanged();

        // Se o radio button "Abordado" estiver selecionado, subtraia a quantidade do estoque
        if (abordado) {
            // Subtrair quantidade do estoque
            String resultado = bancoController.atualizarEstoque(codBarras, quantidade);
            // Exibe o resultado da operação de subtração do estoque
            Toast.makeText(getContext(), resultado, Toast.LENGTH_SHORT).show();
        }

        // Limpar os campos de entrada de texto após o registro do furto
        limparCampos();
    }
    private void consultarFurto() {
        // Obter os furtos do banco de dados
        BancoController bancoController = new BancoController(getContext());
        List<ModeloDadosFurtos> furtos = bancoController.ConsultarFurtos();

        // Verificar se há furtos
        if (furtos.isEmpty()) {
            // Se não houver furtos, exibir uma mensagem de aviso
            Toast.makeText(getContext(), "Nenhum furto encontrado.", Toast.LENGTH_SHORT).show();
        } else {
            // Se houver furtos, atualizar a lista na interface do usuário
            listaFurtos.clear();
            listaFurtos.addAll(furtos);
            furtosAdapter.notifyDataSetChanged();
        }
    }

    private void excluirFurto() {
        // Obter a referência para o EditText onde o usuário irá inserir a data do furto
        EditText etxtDataFurto = getView().findViewById(R.id.etxtDataFurto);

        String dataFurto = etxtDataFurto.getText().toString().trim();

        // Verificar se a data fornecida pelo usuário está vazia
        if (dataFurto.isEmpty()) {
            Toast.makeText(getContext(), "Por favor, insira a data do furto", Toast.LENGTH_SHORT).show();
        } else {
            BancoController bancoController = new BancoController(getContext());
            String dataParaExcluir = bancoController.DataFurto(dataFurto);

            // Verificar se a data do furto está cadastrada
            if (dataParaExcluir != null) {

                // Chama o método no BancoController para excluir
                bancoController.excluirFurtoPorData(getContext(), dataParaExcluir);
            } else {
                Toast.makeText(getContext(), "Não há furtos na data " + dataFurto, Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void limparCampos() {
        etxtDataFurto.setText("");
        etxtHoraFurto.setText("");
        etxtCodBarrasFurto.setText("");
        etxtQuantFurto.setText("");
        etxtObsFurto.setText("");
        rbtAbordado.setChecked(false);
        rbtNaoAbordado.setChecked(false);
    }

}
