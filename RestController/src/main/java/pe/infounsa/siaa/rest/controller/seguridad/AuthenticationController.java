/**
 * 
 */
package pe.infounsa.siaa.rest.controller.seguridad;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.infounsa.siaa.business.exception.BusinessException;
import pe.infounsa.siaa.business.seguridad.GestionarUsuarioBusiness;
import pe.infounsa.siaa.business.seguridad.dto.UsuarioDto;
import pe.infounsa.siaa.rest.controller.BaseController;
import pe.infounsa.siaa.rest.controller.seguridad.message.LoginRequest;
import pe.infounsa.siaa.rest.controller.seguridad.message.LoginResponse;
import pe.infounsa.siaa.rest.controller.seguridad.message.UsuarioResponse;

/**
 * @author
 *
 */
@RestController
public class AuthenticationController extends BaseController {

	@Autowired
	private GestionarUsuarioBusiness gestionarUsuarioBusiness;
	
	@RequestMapping(value = "/login/auth", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody LoginResponse login(@RequestBody LoginRequest request){
		
		LoginResponse response = new LoginResponse();
		
		//response.setUsername(request.getUsername());
		//Calendar calendar = Calendar.getInstance();
		//Datetime dtime = new Datetime(calendar.getTime());
		response.setLastLogin(new Date());
		response.setStatus("OK");


		return response;
	}
	
	@RequestMapping(value="/usuario/login",method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody UsuarioResponse auntenticateUsuario(@RequestBody LoginRequest request) throws BusinessException{
		
		UsuarioResponse usuarioResponse = new UsuarioResponse();
		UsuarioDto dto = gestionarUsuarioBusiness.loginUsuario(request.getUsername(),request.getPassword());
		
		usuarioResponse.setUsuario(dto);
		return usuarioResponse;
	}
	
	
}
