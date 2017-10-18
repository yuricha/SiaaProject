package pe.infounsa.siaa.domain.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="matricula")
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mat_iid;
	
	private Date mat_dfecha;
	private String mat_vestado;
	private String mat_vtipo;
	private Integer prodet_iid;
	private String per_vcodigo;
	private Integer des_iid;
	private Boolean mat_bestado;
	private Integer arc_iid;
	
	public Matricula(){
		
	}

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

	public Integer getProdet_iid() {
		return prodet_iid;
	}

	public void setProdet_iid(Integer prodet_iid) {
		this.prodet_iid = prodet_iid;
	}

	public String getPer_vcodigo() {
		return per_vcodigo;
	}

	public void setPer_vcodigo(String per_vcodigo) {
		this.per_vcodigo = per_vcodigo;
	}

	public Integer getDes_iid() {
		return des_iid;
	}

	public void setDes_iid(Integer des_iid) {
		this.des_iid = des_iid;
	}

	public Boolean getMat_bestado() {
		return mat_bestado;
	}

	public void setMat_bestado(Boolean mat_bestado) {
		this.mat_bestado = mat_bestado;
	}

	public Integer getArc_iid() {
		return arc_iid;
	}

	public void setArc_iid(Integer arc_iid) {
		this.arc_iid = arc_iid;
	}
	
}
