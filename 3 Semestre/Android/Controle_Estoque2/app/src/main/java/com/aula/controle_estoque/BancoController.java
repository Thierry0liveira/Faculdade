package com.aula.controle_estoque;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BancoController {
    private Context context;
    private CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }

    //--------------------------------------------------------------------------------------------------

    //CADASTRO USUÁRIOS - Refeito
    public String insereDadosUsuario(String txtNome, String txtCpf, String txtFuncao, String txtUsuario, String txtSenha) {
        ContentValues valores;
        long resultado;
        SQLiteDatabase db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put("nome", txtNome);
        valores.put("cpf", txtCpf);
        valores.put("funcao", txtFuncao);
        valores.put("usuario", txtUsuario);
        valores.put("senha", txtSenha);

        resultado = db.insert("usuarios", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao Inserir os Dados do Usuário!";
        else
            return "Dados do Usuário Cadastrados com Sucesso!";
    }

    // LOGIN - Refeito
    public Cursor carregaDadosPeloUsuarioSenha(String usuario, String senha) {
        Cursor cursor;
        //SELECT nome, cpf, funcao, usuario, senha FROM usuarios WHERE usuario= 'digitado' and senha= 'digitado'
        String[] campos = {"idUser", "nome", "cpf", "funcao", "usuario", "senha"};
        String where = "usuario = '" + usuario + "'and senha = '" + senha + "' ";
        SQLiteDatabase db = banco.getReadableDatabase();
        cursor = db.query("usuarios", campos, where, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    //CADASTRAR PRODUTO
    public String insereDadosProdutos(String codBarras, String nome, int qtd, float preco, String fornecedor) {
        ContentValues valores;
        long resultado;
        SQLiteDatabase db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put("codBarras", codBarras);
        valores.put("nomeProduto", nome);
        valores.put("quantidade", qtd);
        valores.put("preco", preco);
        valores.put("fornecedor", fornecedor);

        resultado = db.insert("produtos", null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir produto";
        else
            return "Produto Inserido com sucesso";
    }

    //CONSULTAR PREÇO PRODUTO
    public Cursor ConsultarProdutos(String _codBarras) {
        Cursor cursor;
        //SELECT idProduto, codBarras, nomeProduto, quantidade, preco, fornecedor FROM produtos
        String[] campos = {"idProduto", "codBarras", "nomeProduto", "quantidade", "preco", "fornecedor"};
        String where = "codBarras ='" + _codBarras + "'";
        SQLiteDatabase db = banco.getReadableDatabase();
        cursor = db.query("produtos", campos, where, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    //CONSULTAR REGISTRO DE PRODUTOS
    public Cursor consultaDadosPeloCodBarras(String _codBarras) {
        Cursor cursor;
        String[] campos = {"idProduto", "codBarras", "nomeProduto", "quantidade", "preco", "fornecedor"};
        String where = "codBarras ='" + _codBarras + "'";
        SQLiteDatabase db = banco.getReadableDatabase();
        cursor = db.query("produtos", campos, where, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    //ALTERAR DADOS DE PRODUTOS
    public String alteraDadosProdutos(String codBarras, String nomeProduto, int quantidade, float preco, String fornecedor) {
        String msg = "Dados alterados com sucesso!!!";

        SQLiteDatabase db = banco.getReadableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("codBarras", codBarras);
        valores.put("nomeProduto", nomeProduto);
        valores.put("quantidade", quantidade);
        valores.put("preco", preco);
        valores.put("fornecedor", fornecedor);

        String condicao = "codBarras =" + codBarras;

        int linha;
        linha = db.update("produtos", valores, condicao, null);

        if (linha < 1) {
            msg = "Erro ao alterar os dados";
        }

        db.close();
        return msg;
    }

    //EXCLUIR DADOS DE PRODUTOS
    public String excluiDadosProdutos(String _codBarras) {
        String msg = "Registro Excluído";

        SQLiteDatabase db = banco.getReadableDatabase();

        String condicao = "codBarras = " + _codBarras;

        int linhas;
        linhas = db.delete("produtos", condicao, null);

        if (linhas < 1) {
            msg = "Erro ao Excluir";
        }

        db.close();
        return msg;
    }

    //INSERIR DADOS REQUISIÇÃO
    public String insereDadosRequisicao(String data, String hora, String codBarras, String quantidade, String valorRequisicao, String requisitante) {
        ContentValues valores;
        long resultado;

        SQLiteDatabase db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("data", data);
        valores.put("hora", hora);
        valores.put("codBarras", codBarras);

        // Obter nome do produto pelo código de barras
        String nomeProduto = NomeProduto(codBarras);
        valores.put("nomeProduto", nomeProduto);

        valores.put("quantidade", quantidade);
        valores.put("valorRequisicao", valorRequisicao);
        valores.put("requisitante", requisitante);

        resultado = db.insert("requisicoes", null, valores);

        if (resultado != -1) {
            String estoqueAtualizado = atualizarEstoque(codBarras, Integer.parseInt(quantidade));
            db.close();
            return "Registro inserido com sucesso. " + estoqueAtualizado;
        } else {
            db.close();
            return "Erro ao inserir registro";
        }
    }

    //OBTER A QUANTIDADE DO PRODUTO
    public int QuantidadeDisponivel(String codBarras) {
        SQLiteDatabase db = banco.getReadableDatabase();
        int quantidadeDisponivel = 0;
        String query = "SELECT quantidade FROM produtos WHERE codBarras = ?";
        Cursor cursor = db.rawQuery(query, new String[]{codBarras});
        if (cursor.moveToFirst()) {
            quantidadeDisponivel = cursor.getInt(0);
        }
        cursor.close();
        return quantidadeDisponivel;
    }

    //OBTER O NOME DO PRODUTO
    public String NomeProduto(String codBarras) {
        SQLiteDatabase db = banco.getReadableDatabase();
        String nomeProduto = "";
        String query = "SELECT nomeProduto FROM produtos WHERE codBarras = ?";
        Cursor cursor = db.rawQuery(query, new String[]{codBarras});

        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("nomeProduto");
            if (columnIndex != -1) {
                nomeProduto = cursor.getString(columnIndex);
            }
        }

        if (cursor != null) {
            cursor.close();
        }
        return nomeProduto;
    }

    //OBTER O PREÇO DO PRODUTO
    public float PrecoProduto(String codBarras) {
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT preco FROM produtos WHERE codBarras = ?", new String[]{codBarras});
        if (cursor != null && cursor.moveToFirst()) {
            float preco = cursor.getFloat(cursor.getColumnIndexOrThrow("preco"));
            cursor.close();
            return preco;
        }
        if (cursor != null) {
            cursor.close();
        }
        return -1;
    }

    //ATUALIZAR O ESTOQUE
    public String atualizarEstoque(String codBarras, int quantidadeRequisitada) {
        SQLiteDatabase db = banco.getWritableDatabase();
        int quantidadeAtual = QuantidadeDisponivel(codBarras);
        String msg = "";

        if (quantidadeAtual >= quantidadeRequisitada) {
            int novaQuantidade = quantidadeAtual - quantidadeRequisitada;
            ContentValues values = new ContentValues();
            values.put("quantidade", novaQuantidade);
            db.update("produtos", values, "codBarras = ?", new String[]{codBarras});
            msg = "Estoque atualizado com sucesso.";
        } else {
            msg = "Não há quantidade suficiente do produto disponível.";
        }
        db.close();
        return msg;
    }

    //VERIFICAR SE O CÓDIGO DE BARRAS ESTÁ CADASTRADO NO BANCO
    public boolean verificarSeExiste(String codBarras) {
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM produtos WHERE codBarras = ?", new String[]{codBarras});
        boolean produtoExiste = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return produtoExiste;
    }

    //INSERIR PERDAS
    public String insereDadosPerda(String data, String hora, String codBarras, String quantidade, String valorPerda) {
        ContentValues valores = new ContentValues();
        long resultado;
        SQLiteDatabase db = banco.getWritableDatabase();

        valores.put("data", data);
        valores.put("hora", hora);
        valores.put("codBarras", codBarras);
        valores.put("quantidade", quantidade);
        valores.put("valorPerda", valorPerda);

        resultado = db.insert("perdas", null, valores);
        db.close();

        if (resultado == -1) {
            return "Erro ao inserir perda";
        } else {
            return "Perda inserida com sucesso";
        }
    }

    //INSERIR FURTO
    public long inserirFurto(String data, String hora, String codBarras, int quantidade, boolean abordado, String observacoes) {
        float valorTotal = calcularValorTotalFurto(codBarras, quantidade);

        SQLiteDatabase db = banco.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("data", data);
        values.put("hora", hora);
        values.put("codBarras", codBarras);
        values.put("quantidade", quantidade);
        values.put("abordado", abordado ? 1 : 0); // Armazena 1 se abordado, 0 se não abordado
        values.put("observacoes", observacoes);
        values.put("valorTotal", valorTotal);

        long result = db.insert("furtos", null, values);
        db.close();
        return result;
    }

    // Calcular o valor total do furto com base na quantidade e no preço do produto
    private float calcularValorTotalFurto(String codBarras, int quantidade) {
        float precoUnitario = PrecoProduto(codBarras); // Obter o preço do produto
        return precoUnitario * quantidade;
    }

    //CONSULTAR FURTO
    public List<ModeloDadosFurtos> ConsultarFurtos() {
        List<ModeloDadosFurtos> furtos = new ArrayList<>();
        SQLiteDatabase db = banco.getReadableDatabase();
        String selectQuery = "SELECT * FROM furtos";

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                String data = cursor.getString(cursor.getColumnIndex("data"));
                String hora = cursor.getString(cursor.getColumnIndex("hora"));
                String codBarras = cursor.getString(cursor.getColumnIndex("codBarras"));
                int quantidade = cursor.getInt(cursor.getColumnIndex("quantidade"));
                boolean abordado = Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex("abordado")));
                String observacoes = cursor.getString(cursor.getColumnIndex("observacoes"));
                float valorTotal = cursor.getFloat(cursor.getColumnIndex("valorTotal"));

                ModeloDadosFurtos furto = new ModeloDadosFurtos(data, hora, codBarras, quantidade, abordado, observacoes, valorTotal);
                furtos.add(furto);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return furtos;
    }



    //ALTERAR FURTO
    public boolean alterarFurto(String data, String hora, String codBarras, String quantidade, String status, String observacoes, String total) {
        ContentValues valores = new ContentValues();
        valores.put("hora", hora);
        valores.put("cod_barras", codBarras);
        valores.put("quantidade", quantidade);
        valores.put("status", status);
        valores.put("observacoes", observacoes);
        valores.put("total", total);

        SQLiteDatabase db = banco.getWritableDatabase();
        int resultado = db.update("furtos", valores, "data=?", new String[]{data});
        db.close();

        return resultado > 0;
    }

    //OBTER FURTO PELA DATA
    public String DataFurto(String dataFurto) {
        String dataParaExcluir = null;

        // Abre o banco de dados em modo leitura
        SQLiteDatabase db = banco.getReadableDatabase();

        // Define a consulta SQL para obter a data do furto a ser excluído
        String selectQuery = "SELECT data FROM furtos WHERE data = ?";

        // Executa a consulta
        Cursor cursor = db.rawQuery(selectQuery, new String[]{dataFurto});

        // Verifica se a consulta retornou alguma linha
        if (cursor.moveToFirst()) {
            // Obtém o valor da coluna "data"
            dataParaExcluir = cursor.getString(cursor.getColumnIndex("data"));
        }

        // Fecha o cursor e o banco de dados
        cursor.close();
        db.close();

        return dataParaExcluir;
    }

    //EXCLUIR FURTO
    public void excluirFurtoPorData(Context context, String data) {
        SQLiteDatabase db = banco.getWritableDatabase();

        String whereClause = "data = ?";
        String[] whereArgs = {data};

        int rowsDeleted = db.delete("furtos", whereClause, whereArgs);
        db.close();

        if (rowsDeleted > 0) {
            Toast.makeText(context, "Furtos na data " + data + " excluídos com sucesso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Não há furtos na data " + data, Toast.LENGTH_SHORT).show();
        }

        // Atualiza a exibição na lista de furtos
        ConsultarFurtos();
    }


}