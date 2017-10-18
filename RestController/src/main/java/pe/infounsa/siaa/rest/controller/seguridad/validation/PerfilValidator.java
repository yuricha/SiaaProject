package pe.infounsa.siaa.rest.controller.seguridad.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pe.infounsa.siaa.rest.controller.message.RequestMessage;

@Component
public class PerfilValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return RequestMessage.class.equals(clazz);
	}
 
	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"body.perfil.codigo","validation.request.perfilusuario.codigo.required");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"body.perfil.nombre","validation.request.perfilusuario.nombre.required");
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,"body.perfilusuario.permisos","validation.request.perfilusuario.permisos.required");
		
//		try{
//			
//			Long.parseLong(request.getBody().getPerfilusuario().getPermisos()); 
//			
//		}catch(Exception ex){
//			errors.rejectValue("body.perfilusuario.permisos","validation.request.perfilusuario.permisos.required");
//		}
		
				
	}
	

}
