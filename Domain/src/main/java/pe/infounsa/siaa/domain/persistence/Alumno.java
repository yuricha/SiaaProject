package pe.infounsa.siaa.domain.persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="alumno")
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;
		
	private String alu_vcodigo;
	private Boolean alu_bhabilitado;
	private Boolean alu_bdeuda;
	private String alu_vpassword;
	
	@EmbeddedId
	private PersonaPK id;//Primary key
			
	public Alumno(){
		
	}

	public String getAlu_vcodigo() {
		return alu_vcodigo;
	}

	public void setAlum_vcodigo(String alu_vcodigo) {
		this.alu_vcodigo = alu_vcodigo;
	}

	public Boolean getAlu_bhabilitado() {
		return alu_bhabilitado;
	}

	public void setAlu_bhabilitado(Boolean alu_bhabilitado) {
		this.alu_bhabilitado = alu_bhabilitado;
	}

	public Boolean getAlu_bdeuda() {
		return alu_bdeuda;
	}

	public void setAlu_bdeuda(Boolean alu_bdeuda) {
		this.alu_bdeuda = alu_bdeuda;
	}

	public String getAlu_vpassword() {
		return alu_vpassword;
	}

	public void setAlu_vpassword(String alu_vpassword) {
		this.alu_vpassword = alu_vpassword;
	}

	public PersonaPK getId() {
		return id;
	}

	public void setId(PersonaPK id) {
		this.id = id;
	}	
	
}
