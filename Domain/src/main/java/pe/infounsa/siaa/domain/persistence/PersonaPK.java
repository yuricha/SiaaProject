package pe.infounsa.siaa.domain.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonaPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private String per_vcodigo;

	public String getPer_vcodigo() {
		return per_vcodigo;
	}

	public void setPer_vcodigo(String per_vcodigo) {
		this.per_vcodigo = per_vcodigo;
	}	

}
