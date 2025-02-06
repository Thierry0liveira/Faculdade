package com.aula.solidario_net.ui.cadastroProdutos;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aula.solidario_net.BancoController;
import com.aula.solidario_net.R;


public class CadastroProdutosFragment extends Fragment implements View.OnClickListener {

    EditText txtCADPRODCodBarras, txtCADPRODNome, txtCADPRODQtd, txtCADPRODPreco, txtCADPRODFornecedor;
    Button btCADPRODGravar, btCADPRODConsultar, btCADPRODAlterar, btCADPRODExcluir;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cadastro_produtos, container, false);

        // Inicializar os componentes da interface do usuário
        txtCADPRODCodBarras = view.findViewById(R.id.txtCADPRODCodBarras);
        txtCADPRODNome = view.findViewById(R.id.txtCADPRODNome);
        txtCADPRODQtd = view.findViewById(R.id.txtCADPRODQtd);
        txtCADPRODPreco = view.findViewById(R.id.txtCADPRODPreco);
        txtCADPRODFornecedor = view.findViewById(R.id.txtCADPRODFornecedor);
        btCADPRODGravar = view.findViewById(R.id.btCADPRODGravar);
        btCADPRODConsultar = view.findViewById(R.id.btCADPRODConsultar);
        btCADPRODAlterar = view.findViewById(R.id.btCADPRODAlterar);
        btCADPRODExcluir = view.findViewById(R.id.btCADPRODExcluir);

        // Definir os ouvintes de clique
        btCADPRODGravar.setOnClickListener(this);
        btCADPRODConsultar.setOnClickListener(this);
        btCADPRODAlterar.setOnClickListener(this);
        btCADPRODExcluir.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btCADPRODGravar) {
            if (validaDados()) {
                // Gravar dados
                salvarDados();
            }
        }

        if (v.getId() == R.id.btCADPRODConsultar) {
            consultarDados();
        }

        if (v.getId() == R.id.btCADPRODAlterar) {
            alterarDados();
        }

        if (v.getId() == R.id.btCADPRODExcluir) {
            excluirDados();
        }
    }

    private boolean validaDados() {
        String codBarras = txtCADPRODCodBarras.getText().toString().trim();
        String nome = txtCADPRODNome.getText().toString().trim();
        String qtd = txtCADPRODQtd.getText().toString().trim();
        String preco = txtCADPRODPreco.getText().toString().trim();
        String fornecedor = txtCADPRODFornecedor.getText().toString().trim();

        if (codBarras.isEmpty()) {
            Toast.makeText(getContext(), "O campo CÓDIGO DE BARRAS deve ser preenchido", Toast.LENGTH_LONG).show();
            return false;
        }
        if (nome.isEmpty()) {
            Toast.makeText(getContext(), "O campo NOME DO PRODUTO deve ser preenchido", Toast.LENGTH_LONG).show();
            return false;
        }
        if (qtd.isEmpty()) {
            Toast.makeText(getContext(), "O campo QUANTIDADE deve ser preenchido", Toast.LENGTH_LONG).show();
            return false;
        }
        if (preco.isEmpty()) {
            Toast.makeText(getContext(), "O campo PREÇO deve ser preenchido", Toast.LENGTH_LONG).show();
            return false;
        }
        if (fornecedor.isEmpty()) {
            Toast.makeText(getContext(), "O campo FORNECEDOR deve ser preenchido", Toast.LENGTH_LONG).show();
            return false;
        }
        // Verificação adicional para garantir que qtd e preco sejam numéricos
        try {
            Integer.parseInt(qtd);
            Float.parseFloat(preco);
        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Quantidade e Preço devem ser numéricos.", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public void salvarDados() {
        String codBarras = txtCADPRODCodBarras.getText().toString().trim();
        String nomeProduto = txtCADPRODNome.getText().toString().trim();
        int quantidade = Integer.parseInt(txtCADPRODQtd.getText().toString().trim());
        float preco = Float.parseFloat(txtCADPRODPreco.getText().toString().trim());
        String fornecedor = txtCADPRODFornecedor.getText().toString().trim();

        BancoController bd = new BancoController(getContext());
        String resultado;

        resultado = bd.insereDadosProdutos(codBarras, nomeProduto, quantidade, preco, fornecedor);

        Toast.makeText(getContext(), resultado, Toast.LENGTH_LONG).show();

        limpar();
    }

    private void consultarDados() {
        String codBarras = txtCADPRODCodBarras.getText().toString().trim();

        BancoController bd = new BancoController(getContext());

        Cursor dados = bd.consultaDadosPeloCodBarras(codBarras);

        if (dados.moveToFirst()) {
            txtCADPRODCodBarras.setText(dados.getString(1));
            txtCADPRODNome.setText(dados.getString(2));
            txtCADPRODQtd.setText(dados.getString(3));
            txtCADPRODPreco.setText(dados.getString(4));
            txtCADPRODFornecedor.setText(dados.getString(5));
        } else {
            String msg = "Código não cadastrado";
            Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
            limpar();
        }
    }

    public void alterarDados() {
        String codBarras = txtCADPRODCodBarras.getText().toString().trim();
        String nomeProduto = txtCADPRODNome.getText().toString().trim();
        int quantidade = 0;
        float preco = 0;
        String fornecedor = txtCADPRODFornecedor.getText().toString().trim();
        String msg = "";
        boolean erro = false;

        if (codBarras.length()==0)
        {
            msg="Preencha corretamente o campo Código de Barras";
            Toast.makeText(getContext(),msg, Toast.LENGTH_LONG).show();
            erro = true;
        }
        if (nomeProduto.length()==0){
            msg="Preencha corretamente o campo Nome do Produto";
            Toast.makeText(getContext(),msg, Toast.LENGTH_LONG).show();
            erro = true;
        }
        if (txtCADPRODQtd.getText().toString().length()==0)
        {
            msg="Preencha corretamente o campo Quantidade";
            Toast.makeText(getContext(),msg, Toast.LENGTH_LONG).show();
            erro = true;
        }else{
            quantidade = Integer.parseInt(txtCADPRODQtd.getText().toString());
        }
        if (txtCADPRODPreco.getText().toString().length()==0)
        {
            msg="Preencha corretamente o campo Preço";
            Toast.makeText(getContext(),msg, Toast.LENGTH_LONG).show();
            erro = true;
        }else{
            preco = Float.parseFloat(txtCADPRODPreco.getText().toString());
        }
        if (fornecedor.length()==0){
            msg="Preencha corretamente o campo Fornecedor";
            Toast.makeText(getContext(),msg, Toast.LENGTH_LONG).show();
            erro = true;
        }
        if (erro==false){
            BancoController bd = new BancoController(getContext());
            msg = bd.alteraDadosProdutos(codBarras, nomeProduto, quantidade, preco, fornecedor) ;
            Toast.makeText(getContext(),msg, Toast.LENGTH_LONG).show();
            limpar();
        }

    }
    public void excluirDados() {
        String codBarras = txtCADPRODCodBarras.getText().toString().trim();

        BancoController bd = new BancoController(getContext());
        String resultado = bd.excluiDadosProdutos(codBarras);

        Toast.makeText(getContext(), resultado, Toast.LENGTH_LONG).show();
        limpar();
    }
    private void limpar() {
        txtCADPRODCodBarras.setText("");
        txtCADPRODNome.setText("");
        txtCADPRODQtd.setText("");
        txtCADPRODPreco.setText("");
        txtCADPRODFornecedor.setText("");
    }
}