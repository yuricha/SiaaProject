package pe.infounsa.siaa.business.mantenimiento.dto;

import java.util.Date;

public class MatriculaDTO {
	
	private int mat_iid;	
	private Date mat_dfecha;
	private String mat_vestado;
	private String mat_vtipo;	
	private Boolean mat_bestado;
	
	private ProgramacionDetalleDTO dtoProgramacionDetalle;
	private PersonaDTO dtoPersona;
	private DescuentoDTO dtoDescuento;
	private ArchivoDTO dtoArchivo;
	
	public int getMat_iid() {
		return mat_iid;
	}
	public void setMat_iid(int mat_iid) {
		this.mat_iid = mat_iid;
	}
	public Date getMat_dfecha() {
		return mat_dfecha;
	}
	public void setMat_dfecha(Date mat_dfecha) {
		this.mat_dfecha = mat_dfecha;
	}
	public String getMat_vestado() {
		return mat_vestado;
	}
	public void setMat_vestado(String mat_vestado) {
		this.mat_vestado = mat_vestado;
	}
	public String getMat_vtipo() {
		return mat_vtipo;
	}
	public void setMat_vtipo(String mat_vtipo) {
		this.mat_vtipo = mat_vtipo;
	}
	public Boolean getMat_bestado() {
		return mat_bestado;
	}
	public void setMat_bestado(Boolean mat_bestado) {
		this.mat_bestado = mat_bestado;
	}
	public ProgramacionDetalleDTO getDtoProgramacionDetalle() {
		return dtoProgramacionDetalle;
	}
	public void setDtoProgramacionDetalle(
			ProgramacionDetalleDTO dtoProgramacionDetalle) {
		this.dtoProgramacionDetalle = dtoProgramacionDetalle;
	}
	public PersonaDTO getDtoPersona() {
		return dtoPersona;
	}
	public void setDtoPersona(PersonaDTO dtoPersona) {
		this.dtoPersona = dtoPersona;
	}
	public DescuentoDTO getDtoDescuento() {
		return dtoDescuento;
	}
	public void setDtoDescuento(DescuentoDTO dtoDescuento) {
		this.dtoDescuento = dtoDescuento;
	}
	public ArchivoDTO getDtoArchivo() {
		return dtoArchivo;
	}
	public void setDtoArchivo(ArchivoDTO dtoArchivo) {
		this.dtoArchivo = dtoArchivo;
	}

}
