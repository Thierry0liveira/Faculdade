package aplicativo;

import java.util.Date;

public class Dashboards {
	protected int dashboardID;
	public Denuncias denunciaID;
    protected Secretarios secretarioID;
    protected Prefeito prefeitoID;
    public OS ordemID;
    public String tipodashboard;
    public String dados;
    public Date datacriacao;
    public Date dataatualizacao;
    
    public int getDashboardID() {
        return this.dashboardID;
    }
    public void setDashboard(int dashboardID) {
        this.dashboardID = dashboardID;
    }    
    public Denuncias getDenunciaID() {
        return this.denunciaID;
    }
    public void setDenunciaID(Denuncias denunciaID) {
        this.denunciaID = denunciaID;
    }
    public Secretarios getSecretarioID() {
        return this.secretarioID;
    }
    public void setSecretarioID(Secretarios secretarioID) {
        this.secretarioID = secretarioID;
    }
    public Prefeito getPrefeitoID() {
        return this.prefeitoID;
    }
    public void setPrefeitoID(Prefeito prefeitoID) {
        this.prefeitoID = prefeitoID;
    }
    public OS getOrdemID() {
        return this.ordemID;
    }
    public void setOrdemID(OS ordemID) {
        this.ordemID = ordemID;
    }
    public String getTipodashboard() {
        return this.tipodashboard;
    }
    public void setTipodashboard(String tipodashboard) {
        this.tipodashboard = tipodashboard;
    }
    public String getDados() {
        return this.dados;
    }
    public void setDados(String dados) {
        this.dados = dados;
    }
    public Date getDatacriacao() {
        return this.datacriacao;
    }
    public void setDatacriacao(Date datacriacao) {
        this.datacriacao = datacriacao;
    }
    public Date getDataatualizacao() {
        return this.dataatualizacao;
    }
    public void setDataatualizacao(Date dataatualizacao) {
        this.dataatualizacao = dataatualizacao;
    }
    
    protected int ConsultarDashboards() {
		System.out.println("ID Dashboard: " + this.getDashboardID());
		System.out.println("ID Denúncia: " + this.getDenunciaID());
		System.out.println("ID Secretário: " + this.getSecretarioID());
		System.out.println("ID Prefeito: " + this.getPrefeitoID());
		System.out.println("ID OS: " + this.getOrdemID());
		System.out.println("Tipo de Dashboard: " + this.getTipodashboard());
		System.out.println("Dados: " + this.getDados());
		System.out.println("Data de Criação: " + this.getDatacriacao());
		System.out.println("Data Atualização " + this.getDataatualizacao());
		return 0;
	}
}
