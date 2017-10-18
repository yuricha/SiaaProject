package pe.infounsa.siaa.domain.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="persona")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
		
	@EmbeddedId
	private PersonaPK sid;//(Primary key) - Código de identificacion alfanumérico de la persona
	
	@Column(name="per_vtipodocumento")
	private String vtipodocumento;
	
	@Column(name="per_vnumerodocumento")
	private String vnumerodocumento;
	
	@Column(name="per_vtipopersona")
	private String vtipopersona;
	
	@Column(name="per_vnombrecompleto")
	private String vnombrecompleto;
	
	@Column(name="per_vsexo")
	private String vsexo;	
	
	@Temporal(TemporalType.DATE)
	@Column(name="per_dfechanacimiento")
	private Date dfechanacimiento;
	
	@Column(name="per_vmail")
	private String vmail;
	
	@Column(name="per_vmovil")
	private String vmovil;
	
	@Column(name="per_vobservacion")
	private String vobservacion;
	
	@Column(name="per_beliminado")
	private Boolean beliminado;	
	
	@Column(name="arc_iid")
	private Integer iidarchivo;//Código de identificación del archivo que hace referencia a la tabla "archivo"
		
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
		
	public Persona(){
		
	}		

	public PersonaPK getSid() {
		return sid;
	}

	public void setSid(PersonaPK sid) {
		this.sid = sid;
	}

	public String getVtipodocumento() {
		return vtipodocumento;
	}

	public void setVtipodocumento(String vtipodocumento) {
		this.vtipodocumento = vtipodocumento;
	}

	public String getVnumerodocumento() {
		return vnumerodocumento;
	}

	public void setVnumerodocumento(String vnumerodocumento) {
		this.vnumerodocumento = vnumerodocumento;
	}

	public String getVtipopersona() {
		return vtipopersona;
	}

	public void setVtipopersona(String vtipopersona) {
		this.vtipopersona = vtipopersona;
	}

	public String getVnombrecompleto() {
		return vnombrecompleto;
	}

	public void setVnombrecompleto(String vnombrecompleto) {
		this.vnombrecompleto = vnombrecompleto;
	}

	public String getVsexo() {
		return vsexo;
	}

	public void setVsexo(String vsexo) {
		this.vsexo = vsexo;
	}

	public Date getDfechanacimiento() {
		return dfechanacimiento;
	}

	public void setDfechanacimiento(Date dfechanacimiento) {
		this.dfechanacimiento = dfechanacimiento;
	}

	public String getVmail() {
		return vmail;
	}

	public void setVmail(String vmail) {
		this.vmail = vmail;
	}

	public String getVmovil() {
		return vmovil;
	}

	public void setVmovil(String vmovil) {
		this.vmovil = vmovil;
	}

	public String getVobservacion() {
		return vobservacion;
	}

	public void setVobservacion(String vobservacion) {
		this.vobservacion = vobservacion;
	}

	public Boolean getBeliminado() {
		return beliminado;
	}

	public void setBeliminado(Boolean beliminado) {
		this.beliminado = beliminado;
	}	

	public Integer getIidarchivo() {
		return iidarchivo;
	}

	public void setIidarchivo(Integer iidarchivo) {
		this.iidarchivo = iidarchivo;
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
