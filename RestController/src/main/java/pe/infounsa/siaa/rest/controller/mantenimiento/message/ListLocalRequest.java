package pe.infounsa.siaa.rest.controller.mantenimiento.message;

import java.util.List;

import pe.infounsa.siaa.business.mantenimiento.dto.LocalDTO;
import pe.infounsa.siaa.rest.controller.message.RequestBody;

public class ListLocalRequest extends RequestBody{
	
	private List<LocalDTO> dataDto;

	public List<LocalDTO> getDataDto() {
		return dataDto;
	}

	public void setDataDto(List<LocalDTO> dataDto) {
		this.dataDto = dataDto;
	}	

}
