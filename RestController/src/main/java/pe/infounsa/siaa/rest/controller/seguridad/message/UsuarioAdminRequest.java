package pe.infounsa.siaa.rest.controller.seguridad.message;

import pe.infounsa.siaa.business.seguridad.dto.UsuarioAdminDto;
import pe.infounsa.siaa.rest.controller.message.RequestBody;

public class UsuarioAdminRequest extends RequestBody {

	private UsuarioAdminDto usuario;

	public UsuarioAdminDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioAdminDto usuario) {
		this.usuario = usuario;
	}
	
}
