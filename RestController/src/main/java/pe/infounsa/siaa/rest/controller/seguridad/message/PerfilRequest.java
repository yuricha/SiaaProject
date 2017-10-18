package pe.infounsa.siaa.rest.controller.seguridad.message;

import pe.infounsa.siaa.business.seguridad.dto.PerfilDto;
import pe.infounsa.siaa.rest.controller.message.RequestBody;

public class PerfilRequest extends RequestBody{
	
	private PerfilDto perfil;

	public PerfilDto getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDto perfil) {
		this.perfil = perfil;
	}
	
}
