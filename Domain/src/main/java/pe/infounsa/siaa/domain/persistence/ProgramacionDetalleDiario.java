package pe.infounsa.siaa.domain.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="programacion_detalle_diario")
public class ProgramacionDetalleDiario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int prodetdia_iid;
	
	private Integer prodet_iid;
	private Integer prodetdia_ncantidadhora;
	private String prodetdia_vdia;
	private Boolean prodetdia_bestado;
	
//	@OneToOne
//	@JoinColumn(name="aul_iid")
//	private Aula aul_iid;	
	private Integer aul_iid;
	
	private String pro_vcodigoantiguo;
	
	@Temporal(TemporalType.TIME)
	private Date prodetdia_thorainicio;
	
	@Temporal(TemporalType.TIME)
	private Date prodetdia_thorafin;
	
	public ProgramacionDetalleDiario(){
		
	}

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

	public Integer getAul_iid() {
		return aul_iid;
	}

	public void setAul_iid(Integer aul_iid) {
		this.aul_iid = aul_iid;
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
