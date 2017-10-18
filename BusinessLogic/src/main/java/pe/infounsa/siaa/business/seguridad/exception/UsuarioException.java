package pe.infounsa.siaa.business.seguridad.exception;

import pe.infounsa.siaa.business.exception.BusinessException;

@SuppressWarnings("serial")
public class UsuarioException extends BusinessException{

	public UsuarioException(String code, String message) {
		super(code, message);
	}
	
	public UsuarioException(String code, String message, Exception exception) {
		super(code, message, exception); 
	}
	
	
}
