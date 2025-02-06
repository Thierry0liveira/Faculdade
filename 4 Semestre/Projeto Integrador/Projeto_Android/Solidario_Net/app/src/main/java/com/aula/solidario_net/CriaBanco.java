package com.aula.solidario_net;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco_exemplo.db";
    private static final int VERSAO = 18;
    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE usuarios ("
                + "idUser integer primary key autoincrement,"
                + "nome text,"
                + "cpf text unique,"
                + "funcao text,"
                + "usuario text,"
                + "senha text)";
        db.execSQL(sql);
        sql = "CREATE TABLE produtos ("
                + "idProduto integer primary key autoincrement,"
                + "codBarras text unique,"
                + "nomeProduto text,"
                + "quantidade int,"
                + "preco float,"
                + "fornecedor text)";
        db.execSQL(sql);
        sql = "CREATE TABLE requisicoes ("
                + "idRequisicao integer primary key autoincrement,"
                + "data text,"
                + "hora text,"
                + "codBarras text,"
                + "nomeProduto text,"
                + "quantidade int,"
                + "requisitante text,"
                + "valorRequisicao float,"
                + "Foreign KEY(codBarras) REFERENCES produtos(codBarras))";
        db.execSQL(sql);
        sql = "CREATE TABLE perdas ("
                + "id integer PRIMARY KEY AUTOINCREMENT,"
                + "data text,"
                + "hora text,"
                + "codBarras text,"
                + "quantidade int,"
                + "valorPerda float,"
                + "Foreign KEY(codBarras) REFERENCES produtos(codBarras))";
        db.execSQL(sql);
        sql = "CREATE TABLE furtos ("
                + "id integer PRIMARY KEY AUTOINCREMENT,"
                + "data text, "
                + "hora text, "
                + "codBarras text, "
                + "quantidade int, "
                + "abordado text, "
                + "observacoes text, "
                + "valorTotal float,"
                + "Foreign KEY(codBarras) REFERENCES produtos(codBarras))";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS produtos");
        db.execSQL("DROP TABLE IF EXISTS requisicoes");
        db.execSQL("DROP TABLE IF EXISTS perdas");
        db.execSQL("DROP TABLE IF EXISTS furtos");
        onCreate(db);
    }
}