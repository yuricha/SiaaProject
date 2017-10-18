package pe.infounsa.siaa.rest.controller.seguridad.message;

import pe.infounsa.siaa.business.seguridad.dto.PerfilDto;
import pe.infounsa.siaa.rest.controller.message.ResponseBody;

public class PerfilResponse extends ResponseBody{
	
	private String message;
	private PerfilDto perfil;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public PerfilDto getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilDto perfil) {
		this.perfil = perfil;
	}
	
}
