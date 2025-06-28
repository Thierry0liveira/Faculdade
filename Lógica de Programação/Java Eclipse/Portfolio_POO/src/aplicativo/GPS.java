package aplicativo;

import java.util.Date;

public class GPS {
	protected int GPSID;
    public OS ordemID;
    protected double latitude;
    protected double longitude;
    protected Date dataatualizacaoGPS;
    
    public int getGPSID() {
        return this.GPSID;
    }

    public void setGPSID(int gpsID) {
        this.GPSID = gpsID;
    }

    public OS getOrdemID() {
        return this.ordemID;
    }

    public void setOrdemID(OS ordemID) {
        this.ordemID = ordemID;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getDataatualizacaoGPS() {
        return this.dataatualizacaoGPS;
    }

    public void setDataatualizacaoGPS(Date dataatualizacaoGPS) {
        this.dataatualizacaoGPS = dataatualizacaoGPS;
    }
    
    protected int ConsultarGPS() {
		System.out.println("ID GPS: " + this.getGPSID());
		System.out.println("ID OS: " + this.getOrdemID());
		System.out.println("Latitude: " + this.getLatitude());
		System.out.println("Longitude: " + this.getLongitude());
		System.out.println("Data Atualização " + this.getDataatualizacaoGPS());
		return 0;
	}
}
