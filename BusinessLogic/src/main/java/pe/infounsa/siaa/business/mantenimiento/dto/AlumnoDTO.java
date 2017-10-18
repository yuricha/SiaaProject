package pe.infounsa.siaa.business.mantenimiento.dto;

public class AlumnoDTO {
	
	private String alu_vcodigo;	
	private Boolean alu_bhabilitado;
	private Boolean alu_bdeuda;
	private String alu_vpassword;
	
	private PersonaDTO dtoPersona;

	public String getAlu_vcodigo() {
		return alu_vcodigo;
	}

	public void setAlu_vcodigo(String alu_vcodigo) {
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

	public PersonaDTO getDtoPersona() {
		return dtoPersona;
	}

	public void setDtoPersona(PersonaDTO dtoPersona) {
		this.dtoPersona = dtoPersona;
	}

}
