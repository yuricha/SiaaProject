package pe.infounsa.siaa.business.mantenimiento.dto;

import java.util.Date;

public class ProgramacionDetalleDiarioDTO {
	
	private int prodetdia_iid;	
	private Integer prodet_iid;
	private Integer prodetdia_ncantidadhora;
	private String prodetdia_vdia;
	private Boolean prodetdia_bestado;
	private AulaDTO dtoAula;	
	private String pro_vcodigoantiguo;	
	private Date prodetdia_thorainicio;
	private Date prodetdia_thorafin;
	
	public int getProdetdia_iid() {
		return prodetdia_iid;
	}
	public void setProdetdia_iid(int prodetdia_iid) {
		this.prodetdia_iid = prodetdia_iid;
	}
	public Integer getProdet_iid() {
		return prodet_iid;
	}
	public void setProdet_iid(Integer prodet_iid) {
		this.prodet_iid = prodet_iid;
	}
	public Integer getProdetdia_ncantidadhora() {
		return prodetdia_ncantidadhora;
	}
	public void setProdetdia_ncantidadhora(Integer prodetdia_ncantidadhora) {
		this.prodetdia_ncantidadhora = prodetdia_ncantidadhora;
	}
	public String getProdetdia_vdia() {
		return prodetdia_vdia;
	}
	public void setProdetdia_vdia(String prodetdia_vdia) {
		this.prodetdia_vdia = prodetdia_vdia;
	}
	public Boolean getProdetdia_bestado() {
		return prodetdia_bestado;
	}
	public void setProdetdia_bestado(Boolean prodetdia_bestado) {
		this.prodetdia_bestado = prodetdia_bestado;
	}
	public AulaDTO getDtoAula() {
		return dtoAula;
	}
	public void setDtoAula(AulaDTO dtoAula) {
		this.dtoAula = dtoAula;
	}
	public String getPro_vcodigoantiguo() {
		return pro_vcodigoantiguo;
	}
	public void setPro_vcodigoantiguo(String pro_vcodigoantiguo) {
		this.pro_vcodigoantiguo = pro_vcodigoantiguo;
	}
	public Date getProdetdia_thorainicio() {
		return prodetdia_thorainicio;
	}
	public void setProdetdia_thorainicio(Date prodetdia_thorainicio) {
		this.prodetdia_thorainicio = prodetdia_thorainicio;
	}
	public Date getProdetdia_thorafin() {
		return prodetdia_thorafin;
	}
	public void setProdetdia_thorafin(Date prodetdia_thorafin) {
		this.prodetdia_thorafin = prodetdia_thorafin;
	}

}
