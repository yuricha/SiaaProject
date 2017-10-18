package pe.infounsa.siaa.domain.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="local")
public class Local implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="loc_iid")
	private int iid;
	
	@Column(name="loc_vnombre")
	private String vnombre;
	
	@Column(name="loc_vtelefono")
	private String vtelefono;
	
	@Column(name="loc_vdireccion")
	private String vdireccion;
	
	@Column(name="loc_bhabilitado")
	private Boolean bhabilitado;

	@Column(name="loc_beliminado")
	private Boolean beliminado;
	
	@Column(name="per_vcodigocoordinador")
	private String vcodigocoordinador;
	
	@Column(name="sed_iid")
	private Integer iidsede;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dfechacreacion")
	private Date dfechacreacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dfechaeliminacion")
	private Date dfechaeliminacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dfechamodificacion")
	private Date dfechamodificacion;
	
	@Column(name="vusuariocreacion")
	private String vusuariocreacion;
	
	@Column(name="vusuarioeliminacion")
	private String vusuarioeliminacion;
	
	@Column(name="vusuariomodificacion")
	private String vusuariomodificacion;
	
	@Column(name="vip")
	private String vip;
	
	public Local(){
		
	}

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

	public Boolean getBhabilitado() {
		return bhabilitado;
	}

	public void setBhabilitado(Boolean bhabilitado) {
		this.bhabilitado = bhabilitado;
	}

	public Boolean getBeliminado() {
		return beliminado;
	}

	public void setBeliminado(Boolean beliminado) {
		this.beliminado = beliminado;
	}

	public String getVcodigocoordinador() {
		return vcodigocoordinador;
	}

	public void setVcodigocoordinador(String vcodigocoordinador) {
		this.vcodigocoordinador = vcodigocoordinador;
	}

	public Integer getIidsede() {
		return iidsede;
	}

	public void setIidsede(Integer iidsede) {
		this.iidsede = iidsede;
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
