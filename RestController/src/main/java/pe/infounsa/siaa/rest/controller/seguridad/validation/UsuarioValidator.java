package pe.infounsa.siaa.rest.controller.seguridad.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pe.infounsa.siaa.rest.controller.message.RequestMessage;

@Component
public class UsuarioValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return RequestMessage.class.equals(clazz);
	}
 
	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"body.usuario.usuario","validation.request.usuarios.usuario.required");
		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"body.usuario.contrasena","validation.request.usuarios.contrasena.required");
//		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"body.usuario.activo","validation.request.usuarios.activo.data");
//		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"body.usuario.codigo","validation.request.usuarios.codigo.data");
				
//		if (request.getBody().getUsuario().getActivo() != 0  && request.getBody().getUsuario().getActivo() != 1) {
//		
//			errors.rejectValue("body.usuario.activo","validation.request.usuarios.activo.data");
//		}
			
//		
//		if (request.getBody().getUsuario().getUsuario()== null || request.getBody().getUsuario().getUsuario().isEmpty()) {
//
//			errors.rejectValue("body.usuario.usuario","validation.request.usuarios.usuario.required");
//		}
	}
	

}
