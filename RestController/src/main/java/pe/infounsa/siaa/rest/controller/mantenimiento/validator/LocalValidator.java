package pe.infounsa.siaa.rest.controller.mantenimiento.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pe.infounsa.siaa.rest.controller.mantenimiento.message.ListLocalRequest;
import pe.infounsa.siaa.rest.controller.message.RequestMessage;

@Component
public class LocalValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return RequestMessage.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
			
		@SuppressWarnings("unchecked")
		RequestMessage<ListLocalRequest> request = (RequestMessage<ListLocalRequest>) target;
		 
		if (request.getBody().getDataDto()==null){
			errors.rejectValue("body.dataDto.data","validation.request.dataDto.required");
		}else{
			
			for(int i = 0; i < request.getBody().getDataDto().size(); i++)
			{				
			    ValidationUtils.rejectIfEmptyOrWhitespace(errors,"body.dataDto[" + i + "].vnombre","validation.request.dtoTipobasico.vnombre.required");				
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,"body.dataDto[" + i + "].vdireccion","validation.request.dtoTipobasico.vdireccion.required");
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,"body.dataDto[" + i + "].sede","validation.request.dtoTipobasico.sede.required");
			}	
			
		}						
		
	}

}
