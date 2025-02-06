package com.aula.solidario_net;

public class ModeloDadosFurtos {
    private String data;
    private String hora;
    private String codBarras;
    private int quantidade;
    private boolean abordado;
    private String observacoes;
    private float valorTotal;

    // Adicione todos os campos que a classe deve ter
    public ModeloDadosFurtos(String data, String hora, String codBarras, int quantidade, boolean abordado, String observacoes, float valorTotal) {
        this.data = data;
        this.hora = hora;
        this.codBarras = codBarras;
        this.quantidade = quantidade;
        this.abordado = abordado;
        this.observacoes = observacoes;
        this.valorTotal = valorTotal;
    }

    // Adicione os getters e setters necessários
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isAbordado() {
        return abordado;
    }

    public void setAbordado(boolean abordado) {
        this.abordado = abordado;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}