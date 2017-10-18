package pe.infounsa.siaa.rest.controller.mantenimiento.message;

import pe.infounsa.siaa.business.mantenimiento.dto.TipoBasicoDTO;

public class TipoBasicoResponse{
	
	private TipoBasicoDTO dataDto;
	private String message;
	
	public TipoBasicoDTO getDataDto() {
		return dataDto;
	}
	public void setDataDto(TipoBasicoDTO dataDto) {
		this.dataDto = dataDto;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}	

}
