package com.aula.solidario_net;

public class ModeloDadosPerdas {
    private String data;
    private String hora;
    private String codBarras;
    private String nomeProduto;
    private int quantidade;
    private float valorPerda;
    private float totalParcial;

    // Getters e Setters
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorPerda() {
        return valorPerda;
    }

    public void setValorPerda(float valorPerda) {
        this.valorPerda = valorPerda;
    }

    public float getTotalParcial() {
        return totalParcial;
    }

    public void setTotalParcial(float totalParcial) {
        this.totalParcial = totalParcial;
    }
}
