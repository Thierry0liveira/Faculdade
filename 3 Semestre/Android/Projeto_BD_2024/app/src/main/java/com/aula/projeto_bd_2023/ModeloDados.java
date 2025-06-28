package com.aula.projeto_bd_2023;

public class ModeloDados {
    // modelo da tabela agendamento
    int idAgendamento;
    String data, hora, email;
    //método construtor
    public ModeloDados() {

    }
    public ModeloDados(int _id, String _data, String _hora, String _email){
        this.idAgendamento = _id;
        this.data = _data;
        this.hora = _hora;
        this.email = _email;
    }
    //gets
    public int getIdAgendamento() {
        return this.idAgendamento;
    }
    public String getData() {
        return this.data;
    }
    public String getHora() {
        return this.hora;
    }
    public String getEmail(){
        return this.email;
    }

    //sets
    public void setIdAgendamento(int _id) {
        this.idAgendamento = _id;
    }
    public void setData(String _data) {
        this.data = _data;
    }
    public void setHora(String _hora){
        this.hora = _hora;
    }
    public void setEmail(String _email){
        this.email = _email;
    }

}