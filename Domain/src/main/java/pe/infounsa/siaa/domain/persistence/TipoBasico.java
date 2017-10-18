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
@Table(name="tipo_basico")
public class TipoBasico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="tipbas_iid")
	private int iid;
	
	@Column(name="tipbas_vcodigo")
	private String vcodigo;
	
	@Column(name="tipbas_vtipo")
	private String vtipo;
	
	@Column(name="tipbas_vnombre")
	private String vnombre;
	
	@Column(name="tipbas_vabreviatura")
	private String vabreviatura;
	
	@Column(name="tipbas_vobservacion")
	private String vobservacion;
	
	@Column(name="tipbas_bhabilitado")
	private Boolean bhabilitado;
	
	@Column(name="tipbas_beliminado")
	private Boolean beliminado;
	
	@Column(name="tipbas_iidpadre")
	private Integer iidpadre;
	
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
		
	public TipoBasico(){
		
	}	

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public String getVcodigo() {
		return vcodigo;
	}

	public void setVcodigo(String vcodigo) {
		this.vcodigo = vcodigo;
	}

	public String getVtipo() {
		return vtipo;
	}

	public void setVtipo(String vtipo) {
		this.vtipo = vtipo;
	}

	public String getVnombre() {
		return vnombre;
	}

	public void setVnombre(String vnombre) {
		this.vnombre = vnombre;
	}

	public String getVabreviatura() {
		return vabreviatura;
	}

	public void setVabreviatura(String vabreviatura) {
		this.vabreviatura = vabreviatura;
	}

	public String getVobservacion() {
		return vobservacion;
	}

	public void setVobservacion(String vobservacion) {
		this.vobservacion = vobservacion;
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

	public Integer getIidpadre() {
		return iidpadre;
	}

	public void setIidpadre(Integer iidpadre) {
		this.iidpadre = iidpadre;
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
