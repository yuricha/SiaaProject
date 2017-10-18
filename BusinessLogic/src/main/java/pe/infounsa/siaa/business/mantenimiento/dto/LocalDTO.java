package pe.infounsa.siaa.business.mantenimiento.dto;

public class LocalDTO {

	private int iid;
	private String vnombre;
	private String vtelefono;
	private String vdireccion;	
	private String vcodigocoordinador;
	private Boolean bhabilitado;
	private SedeDTO sede;//connotacion para objetos
		
	public int getIid() {
		return iid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public String getVnombre() {
		return vnombre;
	}
	public void setVnombre(String vnombre) {
		this.vnombre = vnombre;
	}
	public String getVtelefono() {
		return vtelefono;
	}
	public void setVtelefono(String vtelefono) {
		this.vtelefono = vtelefono;
	}
	public String getVdireccion() {
		return vdireccion;
	}
	public void setVdireccion(String vdireccion) {
		this.vdireccion = vdireccion;
	}
	public String getVcodigocoordinador() {
		return vcodigocoordinador;
	}
	public void setVcodigocoordinador(String vcodigocoordinador) {
		this.vcodigocoordinador = vcodigocoordinador;
	}
	public Boolean getBhabilitado() {
		return bhabilitado;
	}
	public void setBhabilitado(Boolean bhabilitado) {
		this.bhabilitado = bhabilitado;
	}
	public SedeDTO getSede() {
		return sede;
	}
	public void setSede(SedeDTO sede) {
		this.sede = sede;
	}		
	
}
