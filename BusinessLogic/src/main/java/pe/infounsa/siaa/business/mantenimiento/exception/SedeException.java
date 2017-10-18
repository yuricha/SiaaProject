package pe.infounsa.siaa.business.mantenimiento.exception;

import pe.infounsa.siaa.business.exception.BusinessException;

@SuppressWarnings("serial")
public class SedeException extends BusinessException{

	public SedeException(String code, String message) {
		super(code, message);
	}
	
	public SedeException(String code, String message, Exception exception) {
		super(code, message, exception); 
	}

}
