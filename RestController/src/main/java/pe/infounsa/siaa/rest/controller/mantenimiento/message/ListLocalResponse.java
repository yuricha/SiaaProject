package pe.infounsa.siaa.rest.controller.mantenimiento.message;

import java.util.List;

import pe.infounsa.siaa.business.mantenimiento.dto.LocalDTO;

public class ListLocalResponse {
	
	private List<LocalDTO> dataDto;
	private String message;
	
	public List<LocalDTO> getDataDto() {
		return dataDto;
	}
	public void setDataDto(List<LocalDTO> dataDto) {
		this.dataDto = dataDto;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
