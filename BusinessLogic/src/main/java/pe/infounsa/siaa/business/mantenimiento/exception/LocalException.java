package pe.infounsa.siaa.business.mantenimiento.exception;

import pe.infounsa.siaa.business.exception.BusinessException;

@SuppressWarnings("serial")
public class LocalException extends BusinessException{

	public LocalException(String code, String message) {
		super(code, message);
	}
	
	public LocalException(String code, String message, Exception exception) {
		super(code, message, exception); 
	}

}
