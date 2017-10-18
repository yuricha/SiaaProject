package pe.infounsa.siaa.rest.controller.seguridad.message;

import pe.infounsa.siaa.business.seguridad.dto.UsuarioDto;
import pe.infounsa.siaa.rest.controller.message.ResponseBody;

public class UsuarioResponse extends ResponseBody {

	private String message;
	private UsuarioDto usuario;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UsuarioDto getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	} 
	
}
