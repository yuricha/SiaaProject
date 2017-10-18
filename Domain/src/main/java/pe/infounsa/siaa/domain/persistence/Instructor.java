package pe.infounsa.siaa.domain.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PersonaPK id;
	
	private String ins_vcodigo;
	private Date ins_dfechaingreso;
	private String ins_vsegurosocial;
	private String ins_vobservacion;
	private Boolean ins_beliminado;	
	private Date dfechacreacion;
	private Date dfechaeliminacion;
	private Date dfechamodificacion;
	private String vusuariocreacion;
	private String vusuarioeliminacion;
	private String vusuariomodificacion;
	private String vip;
		
	public Instructor(){
		
	}

	public PersonaPK getId() {
		return id;
	}

	public void setId(PersonaPK id) {
		this.id = id;
	}

	public String getIns_vcodigo() {
		return ins_vcodigo;
	}

	public void setIns_vcodigo(String ins_vcodigo) {
		this.ins_vcodigo = ins_vcodigo;
	}

	public Date getIns_dfechaingreso() {
		return ins_dfechaingreso;
	}

	public void setIns_dfechaingreso(Date ins_dfechaingreso) {
		this.ins_dfechaingreso = ins_dfechaingreso;
	}

	public String getIns_vsegurosocial() {
		return ins_vsegurosocial;
	}

	public void setIns_vsegurosocial(String ins_vsegurosocial) {
		this.ins_vsegurosocial = ins_vsegurosocial;
	}

	public String getIns_vobservacion() {
		return ins_vobservacion;
	}

	public void setIns_vobservacion(String ins_vobservacion) {
		this.ins_vobservacion = ins_vobservacion;
	}

	public Boolean getIns_beliminado() {
		return ins_beliminado;
	}

	public void setIns_beliminado(Boolean ins_beliminado) {
		this.ins_beliminado = ins_beliminado;
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
