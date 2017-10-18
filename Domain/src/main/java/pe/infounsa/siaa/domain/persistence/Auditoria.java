//package pe.infounsa.siaa.domain.persistence;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//
//public class Auditoria {
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="dfechacreacion")
//	private Date dfechacreacion;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="dfechaeliminacion")
//	private Date dfechaeliminacion;
//	
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name="dfechamodificacion")
//	private Date dfechamodificacion;
//	
//	@Column(name="vusuariocreacion")
//	private String vusuariocreacion;
//	
//	@Column(name="vusuarioeliminacion")
//	private String vusuarioeliminacion;
//	
//	@Column(name="vusuariomodificacion")
//	private String vusuariomodificacion;
//	
//	@Column(name="vip")
//	private String vip;
//
//	public Date getDfechacreacion() {
//		return dfechacreacion;
//	}
//
//	public void setDfechacreacion(Date dfechacreacion) {
//		this.dfechacreacion = dfechacreacion;
//	}
//
//	public Date getDfechaeliminacion() {
//		return dfechaeliminacion;
//	}
//
//	public void setDfechaeliminacion(Date dfechaeliminacion) {
//		this.dfechaeliminacion = dfechaeliminacion;
//	}
//
//	public Date getDfechamodificacion() {
//		return dfechamodificacion;
//	}
//
//	public void setDfechamodificacion(Date dfechamodificacion) {
//		this.dfechamodificacion = dfechamodificacion;
//	}
//
//	public String getVusuariocreacion() {
//		return vusuariocreacion;
//	}
//
//	public void setVusuariocreacion(String vusuariocreacion) {
//		this.vusuariocreacion = vusuariocreacion;
//	}
//
//	public String getVusuarioeliminacion() {
//		return vusuarioeliminacion;
//	}
//
//	public void setVusuarioeliminacion(String vusuarioeliminacion) {
//		this.vusuarioeliminacion = vusuarioeliminacion;
//	}
//
//	public String getVusuariomodificacion() {
//		return vusuariomodificacion;
//	}
//
//	public void setVusuariomodificacion(String vusuariomodificacion) {
//		this.vusuariomodificacion = vusuariomodificacion;
//	}
//
//	public String getVip() {
//		return vip;
//	}
//
//	public void setVip(String vip) {
//		this.vip = vip;
//	}		
//
//}
