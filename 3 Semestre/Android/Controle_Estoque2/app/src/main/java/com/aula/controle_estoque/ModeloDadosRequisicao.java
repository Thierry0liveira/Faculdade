package com.aula.controle_estoque;

public class ModeloDadosRequisicao {

    // modelo da tabela requisicao
    int quantidade;
    float valorRequisicao, totalParcial;
    String data, hora, codBarras, nomeProduto, requisitante;

    // método construtor
    public ModeloDadosRequisicao() { }

    // Construtor completo
    public ModeloDadosRequisicao(int quantidade, float valorRequisicao, String data,
                                 String hora, String codBarras, String nomeProduto, String requisitante) {
        this.quantidade = quantidade;
        this.valorRequisicao = valorRequisicao;
        this.data = data;
        this.hora = hora;
        this.codBarras = codBarras;
        this.nomeProduto = nomeProduto;
        this.requisitante = requisitante;
    }

    // gets
    public String getData() {
        return this.data;
    }
    public String getHora() {
        return this.hora;
    }
    public String getCodBarras() {
        return this.codBarras;
    }
    public String getNomeProduto() {
        return this.nomeProduto;
    }
    public int getQuantidade() {
        return this.quantidade;
    }
    public String getRequisitante() {
        return this.requisitante;
    }
    public float getValorRequisicao() {
        return this.valorRequisicao;
    }
    public float getTotalParcial() {
        return this.totalParcial;
    }

    // sets
    public void setData(String _data) {
        this.data = _data;
    }
    public void setHora(String _hora) {
        this.hora = _hora;
    }
    public void setCodBarras(String _codBarras) {
        this.codBarras = _codBarras;
    }
    public void setNomeProduto(String _nomeProduto) {
        this.nomeProduto = _nomeProduto;
    }
    public void setQuantidade(int _quantidade) {
        this.quantidade = _quantidade;
    }
    public void setRequisitante(String _requisitante) {
        this.requisitante = _requisitante;
    }
    public void setValorRequisicao(float _valorRequisicao) {
        this.valorRequisicao = _valorRequisicao;
    }
    public void setTotalParcial(float _totalParcial) {
        this.totalParcial = _totalParcial;
    }
}
