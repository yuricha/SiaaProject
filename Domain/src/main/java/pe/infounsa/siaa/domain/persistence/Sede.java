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
@Table(name="sede")
public class Sede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="sed_iid")
	private int iid;
	
	@Column(name="sed_vnombre")
	private String vnombre;
	
	@Column(name="sed_vdepartamento")
	private String vdepartamento;
	
	@Column(name="sed_vprovincia")
	private String vprovincia;
	
	@Column(name="sed_bhabilitado")
	private Boolean bhabilitado;
	
	@Column(name="sed_beliminado")
	private Boolean beliminado;
	
	@Column(name="per_vcodigoadministrador")
	private String vcodigoadministrador;
	
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
	
	public Sede(){
		
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

	public Boolean getBeliminado() {
		return beliminado;
	}

	public void setBeliminado(Boolean beliminado) {
		this.beliminado = beliminado;
	}

	public String getVcodigoadministrador() {
		return vcodigoadministrador;
	}

	public void setVcodigoadministrador(String vcodigoadministrador) {
		this.vcodigoadministrador = vcodigoadministrador;
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
