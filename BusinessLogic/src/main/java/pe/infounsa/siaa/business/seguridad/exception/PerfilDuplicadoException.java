package pe.infounsa.siaa.business.seguridad.exception;

import pe.infounsa.siaa.business.exception.BusinessException;

@SuppressWarnings("serial")
public class PerfilDuplicadoException extends BusinessException{

	public PerfilDuplicadoException(String code, String message) {
		super(code, message);
	}
	public PerfilDuplicadoException(String code, String message,	Exception exception) {
		super(code, message, exception); 
		
	}

}
