package pe.infounsa.siaa.rest.controller.mantenimiento.message;

import pe.infounsa.siaa.business.mantenimiento.dto.LocalDTO;

public class LocalResponse {
	
	private LocalDTO dataDto;
	private String message;
	
	public LocalDTO getDataDto() {
		return dataDto;
	}
	public void setDataDto(LocalDTO dataDto) {
		this.dataDto = dataDto;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
