package pe.infounsa.siaa.rest.controller.seguridad.message;

import java.util.List;

import pe.infounsa.siaa.business.seguridad.dto.GruposDto;
import pe.infounsa.siaa.rest.controller.message.ResponseBody;

public class GruposResponse extends ResponseBody{
	
	private List<GruposDto> grupos;

	public List<GruposDto> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<GruposDto> grupos) {
		this.grupos = grupos;
	}	

}
