package pe.infounsa.siaa.rest.controller.mantenimiento.message;

import java.util.List;

import pe.infounsa.siaa.business.mantenimiento.dto.TipoBasicoDTO;
import pe.infounsa.siaa.rest.controller.message.RequestBody;

public class ListTipoBasicoRequest extends RequestBody{
	
	private List<TipoBasicoDTO> dataDto;

	public List<TipoBasicoDTO> getDataDto() {
		return dataDto;
	}

	public void setDataDto(List<TipoBasicoDTO> dataDto) {
		this.dataDto = dataDto;
	}

}
