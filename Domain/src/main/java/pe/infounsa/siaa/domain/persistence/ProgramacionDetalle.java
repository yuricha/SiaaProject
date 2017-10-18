package pe.infounsa.siaa.domain.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="programacion_detalle")
public class ProgramacionDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int prodet_iid;
	
	private String cur_vcodigo;
	private Date prodet_dfechainicio;
	private Date prodet_dfechafin;
	private String per_vcodigoinstructor;
	private String per_vcodigoayudantia;
	private Boolean prodet_bestado;
	private Integer pro_iid;
	private String pro_vcodigoantiguo;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="prodet_iid")
	private List<ProgramacionDetalleDiario> detalle_diario;
	
	public ProgramacionDetalle(){
		
	}

	public int getProdet_iid() {
		return prodet_iid;
	}

	public void setProdet_iid(int prodet_iid) {
		this.prodet_iid = prodet_iid;
	}

	public String getCur_vcodigo() {
		return cur_vcodigo;
	}

	public void setCur_vcodigo(String cur_vcodigo) {
		this.cur_vcodigo = cur_vcodigo;
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

	public String getPer_vcodigoinstructor() {
		return per_vcodigoinstructor;
	}

	public void setPer_vcodigoinstructor(String per_vcodigoinstructor) {
		this.per_vcodigoinstructor = per_vcodigoinstructor;
	}

	public String getPer_vcodigoayudantia() {
		return per_vcodigoayudantia;
	}

	public void setPer_vcodigoayudantia(String per_vcodigoayudantia) {
		this.per_vcodigoayudantia = per_vcodigoayudantia;
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

	public List<ProgramacionDetalleDiario> getDetalle_diario() {
		return detalle_diario;
	}

	public void setDetalle_diario(List<ProgramacionDetalleDiario> detalle_diario) {
		this.detalle_diario = detalle_diario;
	}
	
}
