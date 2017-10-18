package pe.infounsa.siaa.rest.controller.seguridad.message;

import java.util.List;

import pe.infounsa.siaa.business.seguridad.dto.UsuarioDto;
import pe.infounsa.siaa.rest.controller.message.ResponseBody;

public class ListUsuarioResponse extends ResponseBody{

	private List<UsuarioDto> usuario;

	public List<UsuarioDto> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<UsuarioDto> usuario) {
		this.usuario = usuario;
	}
	
}
