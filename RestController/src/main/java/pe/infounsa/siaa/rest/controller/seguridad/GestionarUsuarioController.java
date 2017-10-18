package pe.infounsa.siaa.rest.controller.seguridad;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.infounsa.siaa.business.exception.BusinessException;
import pe.infounsa.siaa.business.seguridad.GestionarUsuarioBusiness;
import pe.infounsa.siaa.business.seguridad.dto.UsuarioDto;
import pe.infounsa.siaa.rest.controller.BaseController;
import pe.infounsa.siaa.rest.controller.message.RequestMessage;
import pe.infounsa.siaa.rest.controller.message.ResponseMessage;
import pe.infounsa.siaa.rest.controller.seguridad.message.ListUsuarioResponse;
import pe.infounsa.siaa.rest.controller.seguridad.message.UsuarioAdminRequest;
import pe.infounsa.siaa.rest.controller.seguridad.message.UsuarioRequest;
import pe.infounsa.siaa.rest.controller.seguridad.message.UsuarioResponse;
import pe.infounsa.siaa.rest.controller.seguridad.validation.UsuarioValidator;


@RestController
public class GestionarUsuarioController extends BaseController {

	@Autowired
	private GestionarUsuarioBusiness gestionarUsuarioBusiness;
	
	@Autowired
	private UsuarioValidator usuarioValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(usuarioValidator);
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ResponseMessage<UsuarioResponse> registrarUsuario(@RequestBody @Valid RequestMessage<UsuarioAdminRequest> request) throws BusinessException {
		
		UsuarioDto usuario = new UsuarioDto();
		
		UsuarioAdminRequest usuarioRequest = request.getBody();

		usuario = gestionarUsuarioBusiness.ingresarUsuario(usuarioRequest.getUsuario());//

		ResponseMessage<UsuarioResponse> response = new ResponseMessage<UsuarioResponse>();

		UsuarioResponse usuarioResponse = new UsuarioResponse();

		usuarioResponse.setMessage(getMessage("messages.response.success"));
		
		usuarioResponse.setUsuario(usuario);

		response.setBody(usuarioResponse);

		return response;
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ResponseMessage<ListUsuarioResponse> listarUsurios() {
		
		ResponseMessage<ListUsuarioResponse> response = new ResponseMessage<ListUsuarioResponse>();
		ListUsuarioResponse usuarioResponse = new ListUsuarioResponse();
		
		List<UsuarioDto> listUsuarios=gestionarUsuarioBusiness.obtenerUsuarios();
		
		usuarioResponse.setUsuario(listUsuarios);

		response.setBody(usuarioResponse);

		return response;
		}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.PUT, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ResponseMessage<UsuarioResponse> editarUsuario(@RequestBody @Valid RequestMessage<UsuarioAdminRequest> request) throws BusinessException {
		
		UsuarioDto usuario = new UsuarioDto();
		
		UsuarioAdminRequest usuarioRequest = request.getBody();

		usuario = gestionarUsuarioBusiness.editarUsuario(usuarioRequest.getUsuario());

		ResponseMessage<UsuarioResponse> response = new ResponseMessage<UsuarioResponse>();

		UsuarioResponse usuarioResponse = new UsuarioResponse();

		usuarioResponse.setMessage(getMessage("messages.response.success"));
		
		usuarioResponse.setUsuario(usuario);

		response.setBody(usuarioResponse);

		return response;
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.DELETE, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ResponseMessage<UsuarioResponse> eliminarUsuario(@RequestBody @Valid RequestMessage<UsuarioRequest> request){
		
		UsuarioRequest usuarioRequest = request.getBody();

		gestionarUsuarioBusiness.eliminarUsuario(usuarioRequest.getUsuario().getCodigo());

		ResponseMessage<UsuarioResponse> response = new ResponseMessage<UsuarioResponse>();

		UsuarioResponse usuarioResponse = new UsuarioResponse();

		usuarioResponse.setMessage(getMessage("messages.response.success"));
		
		response.setBody(usuarioResponse);

		return response;
	}
	
	@RequestMapping(value = "/usuario/codigo", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ResponseMessage<UsuarioResponse> obtenerUsuario(@RequestBody RequestMessage<UsuarioRequest> request) throws BusinessException {
		
		UsuarioDto usuario = gestionarUsuarioBusiness.obtenerUsuario(request.getBody().getUsuario().getCodigo());//

		ResponseMessage<UsuarioResponse> response = new ResponseMessage<UsuarioResponse>();

		UsuarioResponse usuarioResponse = new UsuarioResponse();

		usuarioResponse.setMessage(getMessage("messages.response.success"));
		
		usuarioResponse.setUsuario(usuario);

		response.setBody(usuarioResponse);

		return response;
	}
	
	@RequestMapping(value = "/usuario/password", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ResponseMessage<UsuarioResponse> CambiarUsuarioPassword(@RequestParam(value = "password",required = true) String password,@RequestBody @Valid RequestMessage<UsuarioAdminRequest> request) throws BusinessException {
		
		UsuarioDto usuario = new UsuarioDto();
		
		UsuarioAdminRequest usuarioRequest = request.getBody();

		usuario = gestionarUsuarioBusiness.cambiarPasswordUsuario(usuarioRequest.getUsuario(),password);//

		ResponseMessage<UsuarioResponse> response = new ResponseMessage<UsuarioResponse>();

		UsuarioResponse usuarioResponse = new UsuarioResponse();

		usuarioResponse.setMessage(getMessage("messages.response.success"));
		
		usuarioResponse.setUsuario(usuario);

		response.setBody(usuarioResponse);

		return response;
	}
		
}
