package pe.infounsa.siaa.domain.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CursoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	private String cur_vcodigo;
	
	public CursoPK(){
		
	}

	public String getCur_vcodigo() {
		return cur_vcodigo;
	}

	public void setCur_vcodigo(String cur_vcodigo) {
		this.cur_vcodigo = cur_vcodigo;
	}

}
