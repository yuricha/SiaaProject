package pe.infounsa.siaa.business.seguridad.exception;

import pe.infounsa.siaa.business.exception.BusinessException;

@SuppressWarnings("serial")

public class UsuarioDuplicadoException extends BusinessException {

	public UsuarioDuplicadoException(String code, String message) {
		super(code, message);
	}
	
	public UsuarioDuplicadoException(String code, String message,Exception exception) {
		super(code, message, exception); 
	}

}
