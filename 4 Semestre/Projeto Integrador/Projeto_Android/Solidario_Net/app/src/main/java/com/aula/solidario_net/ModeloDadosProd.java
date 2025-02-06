package com.aula.solidario_net;

public class ModeloDadosProd {

    // modelo da tabela produtos
    int id, quantidade;
    float preco;
    String codBarras, nome, fornecedor;

    //método construtor
    public ModeloDadosProd() {

    }
    public ModeloDadosProd(int _id, String _codBarras, String _nome, int _quantidade,
                           float _preco, String _fornecedor){
        this.id = _id;
        this.codBarras = _codBarras;
        this.nome = _nome;
        this.quantidade = _quantidade;
        this.preco = _preco;
        this.fornecedor = _fornecedor;
    }
    //gets
    public int getId() {
        return this.id;
    }
    public String getCodBarras() {
        return this.codBarras;
    }
    public String getNome() {
        return this.nome;
    }
    public int getQuantidade(){
        return this.quantidade;
    }
    public float getPreco() {
        return this.preco;
    }
    public String getFornecedor() {
        return this.fornecedor;
    }

    //sets
    public void setId(int _id) {
        this.id = _id;
    }
    public void setCodBarras(String _codBarras) {
        this.codBarras = _codBarras;
    }
    public void setNome(String _nome){
        this.nome = _nome;
    }
    public void setQuantidade(int _quantidade){
        this.quantidade = _quantidade;
    }
    public void setPreco(float _preco){
        this.preco = _preco;
    }
    public void setFornecedor(String _fornecedor){
        this.fornecedor = _fornecedor;
    }

}
