package pe.infounsa.siaa.rest.controller.mantenimiento.message;

import pe.infounsa.siaa.business.mantenimiento.dto.SedeDTO;

public class SedeResponse {
	
	private SedeDTO dataDto;
	private String message;
	
	public SedeDTO getDataDto() {
		return dataDto;
	}
	public void setDataDto(SedeDTO dataDto) {
		this.dataDto = dataDto;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}	

}
