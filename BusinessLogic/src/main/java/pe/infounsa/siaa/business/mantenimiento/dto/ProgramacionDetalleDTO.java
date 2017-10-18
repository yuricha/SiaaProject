package pe.infounsa.siaa.business.mantenimiento.dto;

import java.util.Date;

public class ProgramacionDetalleDTO {
	
	private int prodet_iid;		
	private Date prodet_dfechainicio;
	private Date prodet_dfechafin;	
	private Boolean prodet_bestado;
	private Integer pro_iid;
	private String pro_vcodigoantiguo;
	
	private CursoDTO dtoCurso;
	private InstructorDTO dtoInstructor;
	private InstructorDTO dtoInstructorAyudantia;
	private ProgramacionDetalleDiarioDTO dtoProgramacionDetalleDiario;
	
	public int getProdet_iid() {
		return prodet_iid;
	}
	public void setProdet_iid(int prodet_iid) {
		this.prodet_iid = prodet_iid;
	}
	public Date getProdet_dfechainicio() {
		return prodet_dfechainicio;
	}
	public void setProdet_dfechainicio(Date prodet_dfechainicio) {
		this.prodet_dfechainicio = prodet_dfechainicio;
	}
	public Date getProdet_dfechafin() {
		return prodet_dfechafin;
	}
	public void setProdet_dfechafin(Date prodet_dfechafin) {
		this.prodet_dfechafin = prodet_dfechafin;
	}
	public Boolean getProdet_bestado() {
		return prodet_bestado;
	}
	public void setProdet_bestado(Boolean prodet_bestado) {
		this.prodet_bestado = prodet_bestado;
	}
	public Integer getPro_iid() {
		return pro_iid;
	}
	public void setPro_iid(Integer pro_iid) {
		this.pro_iid = pro_iid;
	}
	public String getPro_vcodigoantiguo() {
		return pro_vcodigoantiguo;
	}
	public void setPro_vcodigoantiguo(String pro_vcodigoantiguo) {
		this.pro_vcodigoantiguo = pro_vcodigoantiguo;
	}
	public CursoDTO getDtoCurso() {
		return dtoCurso;
	}
	public void setDtoCurso(CursoDTO dtoCurso) {
		this.dtoCurso = dtoCurso;
	}
	public InstructorDTO getDtoInstructor() {
		return dtoInstructor;
	}
	public void setDtoInstructor(InstructorDTO dtoInstructor) {
		this.dtoInstructor = dtoInstructor;
	}
	public InstructorDTO getDtoInstructorAyudantia() {
		return dtoInstructorAyudantia;
	}
	public void setDtoInstructorAyudantia(InstructorDTO dtoInstructorAyudantia) {
		this.dtoInstructorAyudantia = dtoInstructorAyudantia;
	}
	public ProgramacionDetalleDiarioDTO getDtoProgramacionDetalleDiario() {
		return dtoProgramacionDetalleDiario;
	}
	public void setDtoProgramacionDetalleDiario(
			ProgramacionDetalleDiarioDTO dtoProgramacionDetalleDiario) {
		this.dtoProgramacionDetalleDiario = dtoProgramacionDetalleDiario;
	}

}
