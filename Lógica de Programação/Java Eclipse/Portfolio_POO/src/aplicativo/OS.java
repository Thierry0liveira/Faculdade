package aplicativo;

import java.util.Date;

public class OS {
	public int ordemID;
    public Denuncias denunciaID;
    public String descricaoos;
    public String responsavelos;
    public String statusos;
    public Date datacriacaoos;
    protected Date dataatualizacaoos;
    protected float custoos;

    public int getOrdemID() {
        return this.ordemID;
    }

    public void setOrdemID(int ordemID) {
        this.ordemID = ordemID;
    }

    public Denuncias getDenunciaID() {
        return this.denunciaID;
    }

    public void setDenunciaID(Denuncias denunciaID) {
        this.denunciaID = denunciaID;
    }

    public String getDescricaoos() {
        return this.descricaoos;
    }

    public void setDescricaoos(String descricaoos) {
        this.descricaoos = descricaoos;
    }

    public String getResponsavelos() {
        return this.responsavelos;
    }

    public void setResponsavelos(String responsavelos) {
        this.responsavelos = responsavelos;
    }

    public String getStatusos() {
        return this.statusos;
    }

    public void setStatusos(String statusos) {
        this.statusos = statusos;
    }

    public Date getDatacriacaoos() {
        return this.datacriacaoos;
    }

    public void setDatacriacaoos(Date datacriacaoos) {
        this.datacriacaoos = datacriacaoos;
    }

    public Date getDataatualizacaoos() {
        return this.dataatualizacaoos;
    }

    public void setDataatualizacaoos(Date dataatualizacaoos) {
        this.dataatualizacaoos = dataatualizacaoos;
    }

    public float getCustoos() {
        return this.custoos;
    }

    public void setCustoos(float custoos) {
        this.custoos = custoos;
    }
    
    protected int ConsultarOS() {
		System.out.println("ID OS: " + this.getOrdemID());
		System.out.println("ID Denúncia: " + this.getDenunciaID());
		System.out.println("Descrição: " + this.getDescricaoos());
		System.out.println("Responsável: " + this.getResponsavelos());
		System.out.println("Status: " + this.getStatusos());
		System.out.println("Data de Criação: " + this.getDatacriacaoos());
		System.out.println("Data Atualização " + this.getDataatualizacaoos());
		System.out.println("Custo: " + this.getCustoos());
		return 0;
	}
}
