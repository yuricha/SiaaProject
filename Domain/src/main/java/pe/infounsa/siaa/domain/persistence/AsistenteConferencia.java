package pe.infounsa.siaa.domain.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="asistente_conferencia")
public class AsistenteConferencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tipbas_iid;
	
	private Integer con_iid;
	private Boolean asicon_bestado;
	private String per_vcodigo;
	
	public AsistenteConferencia(){
		
	}

	public int getTipbas_iid() {
		return tipbas_iid;
	}

	public void setTipbas_iid(int tipbas_iid) {
		this.tipbas_iid = tipbas_iid;
	}

	public Integer getCon_iid() {
		return con_iid;
	}

	public void setCon_iid(Integer con_iid) {
		this.con_iid = con_iid;
	}

	public Boolean getAsicon_bestado() {
		return asicon_bestado;
	}

	public void setAsicon_bestado(Boolean asicon_bestado) {
		this.asicon_bestado = asicon_bestado;
	}

	public String getPer_vcodigo() {
		return per_vcodigo;
	}

	public void setPer_vcodigo(String per_vcodigo) {
		this.per_vcodigo = per_vcodigo;
	}	

}
