package pe.infounsa.siaa.rest.controller.seguridad.message;

import pe.infounsa.siaa.business.seguridad.dto.UsuarioDto;
import pe.infounsa.siaa.rest.controller.message.RequestBody;

public class UsuarioRequest extends RequestBody{
	
	private UsuarioDto usuario;

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}	

}
