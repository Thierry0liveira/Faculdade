package com.aula.projeto_bd_2023;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco_exemplo.db";
    private static final int VERSAO = 5;
    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE contatos ("
                + "codigo integer primary key autoincrement,"
                + "nome text,"
                + "email text)";
        db.execSQL(sql);
        sql = "CREATE TABLE usuarios ("
                + "idUser integer primary key autoincrement,"
                + "nome text,"
                + "cpf text,"
                + "email text,"
                + "senha text)";
        db.execSQL(sql);
        sql = "CREATE TABLE pedidos ("
                + "idPedido integer primary key autoincrement,"
                + "email text,"
                + "qtdHamburger int,"
                + "qtdBatata int,"
                + "qtdRefrigerante int,"
                + "valorHamburger float,"
                + "valorBatata float,"
                + "valorRefrigerante float,"
                + "totalGeral float)";
        db.execSQL(sql);
        sql = "CREATE TABLE agendamento ("
                + "idAgendamento integer primary key autoincrement,"
                + "data text,"
                + "hora text,"
                + "email text)";
        db.execSQL(sql);
        sql = "CREATE TABLE produtos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "codBarras text, " +
                "nome text, " +
                "quantidade int, " +
                "preco real, " +
                "fornecedor text);";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contatos");
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS pedidos");
        db.execSQL("DROP TABLE IF EXISTS agendamento");
        db.execSQL("DROP TABLE IF EXISTS produtos");
        onCreate(db);
    }
}
//sql = "CREATE TABLE furtos ("
//                + "idFurto integer primary key autoincrement,"
//                + "data text,"
//                + "hora text,"
//                + "nome text,"
//                + "codBarras text,"
//                + "nomeProduto text,"
//                + "quantFurto int,"
//                + "valorFurto float,"
//                + "abordado text,"
//                + "obsFurto text,"
//                + "Foreign KEY(codBarras) REFERENCES produtos(codBarras),"
//                + "FOREIGN KEY(nome) REFERENCES usuarios(nome))";
//        db.execSQL(sql);
//        sql = "CREATE TABLE perdas ("
//                + "idPerda integer primary key autoincrement,"
//                + "data text,"
//                + "hora text,"
//                + "codBarras text,"
//                + "nomeProduto text,"
//                + "quantPerda int,"
//                + "valorPerda float,"
//                + "cpf text,"
//                + "Foreign KEY(codBarras) REFERENCES produtos(codBarras),"
//                + "FOREIGN KEY(cpf) REFERENCES usuarios(cpf))";
//        db.execSQL(sql);
//        sql = "CREATE TABLE requisicoes ("
//                + "idRequisicao integer primary key autoincrement,"
//                + "data text,"
//                + "hora text,"
//                + "codBarras text,"
//                + "nomeProduto text,"
//                + "quantRequisicao int,"
//                + "valorRequisicao float,"
//                + "cpf text,"
//                + "Foreign KEY(codBarras) REFERENCES produtos(codBarras),"
//                + "FOREIGN KEY(cpf) REFERENCES usuarios(cpf))";
//        db.execSQL(sql);
//        sql = "CREATE TABLE temperaturas ("
//                + "idTemperatura integer primary key autoincrement,"
//                + "cpf text,"
//                + "data text,"
//                + "hora text,"
//                + "freezer int,"
//                + "temperatura text,"
//                + "FOREIGN KEY(cpf) REFERENCES usuarios(cpf))";
//        db.execSQL(sql);
//    }