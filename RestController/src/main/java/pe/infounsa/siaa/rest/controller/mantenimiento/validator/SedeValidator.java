package pe.infounsa.siaa.rest.controller.mantenimiento.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import pe.infounsa.siaa.rest.controller.mantenimiento.message.ListSedeRequest;
import pe.infounsa.siaa.rest.controller.message.RequestMessage;

@Component
public class SedeValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return RequestMessage.class.equals(clazz);
	}
 
	@Override
	public void validate(Object target, Errors errors) {
			
		@SuppressWarnings("unchecked")
		RequestMessage<ListSedeRequest> request = (RequestMessage<ListSedeRequest>) target;
		 
		if (request.getBody().getDataDto()==null){
			errors.rejectValue("body.dataDto.data","validation.request.dataDto.required");
		}else{
			
			for(int i = 0; i < request.getBody().getDataDto().size(); i++)
			{				
			    ValidationUtils.rejectIfEmptyOrWhitespace(errors,"body.dataDto[" + i + "].vnombre","validation.request.vnombre.required");		
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,"body.dataDto[" + i + "].vdepartamento","validation.request.vdepartamento.required");
//				ValidationUtils.rejectIfEmptyOrWhitespace(errors,"body.dataDto[" + i + "].vprovincia","validation.request.vprovincia.required");
			}	
			
		}
	}	

}
