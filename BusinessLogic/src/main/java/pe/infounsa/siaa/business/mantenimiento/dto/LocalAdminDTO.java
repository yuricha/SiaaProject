package pe.infounsa.siaa.business.mantenimiento.dto;

import java.util.Date;

public class LocalAdminDTO extends LocalDTO{
	
	private Boolean beliminado;	
	private Date dfechacreacion;
	private Date dfechaeliminacion;
	private Date dfechamodificacion;
	private String vusuariocreacion;
	private String vusuarioeliminacion;
	private String vusuariomodificacion;
	private String vip;
	
	public Boolean getBeliminado() {
		return beliminado;
	}
	public void setBeliminado(Boolean beliminado) {
		this.beliminado = beliminado;
	}
	public Date getDfechacreacion() {
		return dfechacreacion;
	}
	public void setDfechacreacion(Date dfechacreacion) {
		this.dfechacreacion = dfechacreacion;
	}
	public Date getDfechaeliminacion() {
		return dfechaeliminacion;
	}
	public void setDfechaeliminacion(Date dfechaeliminacion) {
		this.dfechaeliminacion = dfechaeliminacion;
	}
	public Date getDfechamodificacion() {
		return dfechamodificacion;
	}
	public void setDfechamodificacion(Date dfechamodificacion) {
		this.dfechamodificacion = dfechamodificacion;
	}
	public String getVusuariocreacion() {
		return vusuariocreacion;
	}
	public void setVusuariocreacion(String vusuariocreacion) {
		this.vusuariocreacion = vusuariocreacion;
	}
	public String getVusuarioeliminacion() {
		return vusuarioeliminacion;
	}
	public void setVusuarioeliminacion(String vusuarioeliminacion) {
		this.vusuarioeliminacion = vusuarioeliminacion;
	}
	public String getVusuariomodificacion() {
		return vusuariomodificacion;
	}
	public void setVusuariomodificacion(String vusuariomodificacion) {
		this.vusuariomodificacion = vusuariomodificacion;
	}
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}

}
