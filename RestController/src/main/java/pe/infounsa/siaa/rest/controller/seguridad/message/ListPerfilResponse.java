package pe.infounsa.siaa.rest.controller.seguridad.message;

import java.util.List;

import pe.infounsa.siaa.business.seguridad.dto.PerfilDto;
import pe.infounsa.siaa.rest.controller.message.ResponseBody;

public class ListPerfilResponse extends ResponseBody{
	
	private List<PerfilDto> perfil;

	public List<PerfilDto> getPerfil() {
		return perfil;
	}

	public void setPerfil(List<PerfilDto> perfil) {
		this.perfil = perfil;
	}
	
}
