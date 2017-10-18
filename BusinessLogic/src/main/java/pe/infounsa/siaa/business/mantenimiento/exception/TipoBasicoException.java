package pe.infounsa.siaa.business.mantenimiento.exception;

import pe.infounsa.siaa.business.exception.BusinessException;

@SuppressWarnings("serial")
public class TipoBasicoException extends BusinessException{

	public TipoBasicoException(String code, String message) {
		super(code, message);
	}
	
	public TipoBasicoException(String code, String message, Exception exception) {
		super(code, message, exception); 
	}

}
