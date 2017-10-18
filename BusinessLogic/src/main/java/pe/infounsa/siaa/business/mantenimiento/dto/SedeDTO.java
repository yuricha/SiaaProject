package pe.infounsa.siaa.business.mantenimiento.dto;

public class SedeDTO {
	
	private int iid;
	private String vnombre;
	private String vdepartamento;
	private String vprovincia;
	private Boolean bhabilitado;
	private String vcodigoadministrador;
	
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
	public String getVdepartamento() {
		return vdepartamento;
	}
	public void setVdepartamento(String vdepartamento) {
		this.vdepartamento = vdepartamento;
	}
	public String getVprovincia() {
		return vprovincia;
	}
	public void setVprovincia(String vprovincia) {
		this.vprovincia = vprovincia;
	}	
	public Boolean getBhabilitado() {
		return bhabilitado;
	}
	public void setBhabilitado(Boolean bhabilitado) {
		this.bhabilitado = bhabilitado;
	}
	public String getVcodigoadministrador() {
		return vcodigoadministrador;
	}
	public void setVcodigoadministrador(String vcodigoadministrador) {
		this.vcodigoadministrador = vcodigoadministrador;
	}

}
