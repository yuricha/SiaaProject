package pe.infounsa.siaa.business.seguridad.exception;

import pe.infounsa.siaa.business.exception.BusinessException;

@SuppressWarnings("serial")
public class UsuarioPerfilDuplicadoException extends BusinessException{
 
	public UsuarioPerfilDuplicadoException(String code, String message) {
		super(code, message);
	}
	public UsuarioPerfilDuplicadoException(String code, String message,	Exception exception) {
		super(code, message, exception);
		
	}

}
