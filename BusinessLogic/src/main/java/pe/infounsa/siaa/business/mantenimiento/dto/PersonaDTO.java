package pe.infounsa.siaa.business.mantenimiento.dto;

import java.util.Date;

public class PersonaDTO {
	
	private String vcodigo;//Primary key
	private String vtipodocumento;
	private String vnumerodocumento;
	private String vtipopersona;
	private String vnombrecompleto;
	private String vsexo;		
	private Date dfechanacimiento;	
	private String vmail;
	private String vmovil;
	private String vobservacion;
	private Boolean beliminado;	
	
	private ArchivoDTO archivo;//Código de identificación del archivo que hace referencia a la tabla "archivo"

	public String getVcodigo() {
		return vcodigo;
	}

	public void setVcodigo(String vcodigo) {
		this.vcodigo = vcodigo;
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

	public ArchivoDTO getArchivo() {
		return archivo;
	}

	public void setArchivo(ArchivoDTO archivo) {
		this.archivo = archivo;
	}
	
}
