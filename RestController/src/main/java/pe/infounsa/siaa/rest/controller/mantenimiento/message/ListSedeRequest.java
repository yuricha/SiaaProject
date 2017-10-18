package pe.infounsa.siaa.rest.controller.mantenimiento.message;

import java.util.List;

import pe.infounsa.siaa.business.mantenimiento.dto.SedeDTO;
import pe.infounsa.siaa.rest.controller.message.RequestBody;

public class ListSedeRequest extends RequestBody{
	
	private List<SedeDTO> dataDto;

	public List<SedeDTO> getDataDto() {
		return dataDto;
	}

	public void setDataDto(List<SedeDTO> dataDto) {
		this.dataDto = dataDto;
	}

}
