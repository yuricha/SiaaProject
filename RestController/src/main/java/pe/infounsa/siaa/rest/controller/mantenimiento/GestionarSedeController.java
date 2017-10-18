package pe.infounsa.siaa.rest.controller.mantenimiento;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.infounsa.siaa.business.exception.BusinessException;
import pe.infounsa.siaa.business.mantenimiento.GestionarSedeBusiness;
import pe.infounsa.siaa.business.mantenimiento.dto.SedeDTO;
import pe.infounsa.siaa.common.utils.Paginador;
import pe.infounsa.siaa.rest.controller.BaseController;
import pe.infounsa.siaa.rest.controller.mantenimiento.message.ListSedeRequest;
import pe.infounsa.siaa.rest.controller.mantenimiento.validator.SedeValidator;
import pe.infounsa.siaa.rest.controller.message.RequestMessage;
import pe.infounsa.siaa.rest.controller.response.DTOResponse;
import pe.infounsa.siaa.rest.controller.response.ListDTOResponse;

@RestController
public class GestionarSedeController extends BaseController{

	@Autowired
	private GestionarSedeBusiness gestionarSedeBusiness;
	
	@Autowired
	private ListDTOResponse<SedeDTO> listDTOResponse;
	@Autowired
	private DTOResponse<SedeDTO> dtoResponse;
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private SedeValidator sedeValidator;
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(sedeValidator);
	}
	
	@RequestMapping(value = "/sedes", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ListDTOResponse<SedeDTO> registrarSede(@RequestBody @Valid RequestMessage<ListSedeRequest> request) throws BusinessException {
		
		String ip = httpServletRequest.getRemoteAddr();
		
		ListSedeRequest listSedeRequest = request.getBody();			
		List<SedeDTO> listaSedeDTO = gestionarSedeBusiness.guardarSede(listSedeRequest.getDataDto(), ip);

		listDTOResponse.setMessage(getMessage("messages.response.success"));		
		listDTOResponse.setDataDto(listaSedeDTO);

		return listDTOResponse;
	}
	
	@RequestMapping(value = "/sedes", method = RequestMethod.PUT, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ListDTOResponse<SedeDTO> editarSede(@RequestBody @Valid RequestMessage<ListSedeRequest> request) throws BusinessException {
				
		String ip = httpServletRequest.getRemoteAddr();
		
		ListSedeRequest listSedeRequest = request.getBody();			
		List<SedeDTO> listaSedeDTO = gestionarSedeBusiness.editarSede(listSedeRequest.getDataDto(), ip);

		listDTOResponse.setMessage(getMessage("messages.response.success"));		
		listDTOResponse.setDataDto(listaSedeDTO);

		return listDTOResponse;
	}	
	
	@RequestMapping(value = "/sedes", method = RequestMethod.DELETE, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ListDTOResponse<SedeDTO> eliminarSede(@RequestBody RequestMessage<ListSedeRequest> request) throws BusinessException {
								 
		String ip = httpServletRequest.getRemoteAddr();
		
		ListSedeRequest listSedeRequest = request.getBody();			
		gestionarSedeBusiness.eliminarSede(listSedeRequest.getDataDto(), ip);

		listDTOResponse.setMessage(getMessage("messages.response.success"));	

		return listDTOResponse;
	}
		
	@RequestMapping(value = "/sedes/{id}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody DTOResponse<SedeDTO> obtenerSede(@PathVariable int id) throws BusinessException {
		
		SedeDTO sedeDTO = gestionarSedeBusiness.obtenerSede(id);
		
		dtoResponse.setMessage(getMessage("messages.response.success"));
		dtoResponse.setDataDto(sedeDTO);

		return dtoResponse;
	}
	
	//------------------------------------------- PAGINADORES y Normal ---------------------------------------------------------

	@RequestMapping(value = "/sedes", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ListDTOResponse<SedeDTO> listarSedePaginado(HttpServletRequest context) throws BusinessException {

		Paginador paginador = Paginador.getPagination(context);

		List<SedeDTO> listaSedeDto;
		int totalRegistros=0;
		if (paginador == null) {
			listaSedeDto = gestionarSedeBusiness.listarSede();
		}else
			listaSedeDto = gestionarSedeBusiness.listarSedePaginado(paginador.getPageSize(), paginador.getStartIndex());
				
		totalRegistros = listaSedeDto.size();
		
		listDTOResponse.setTotalRegistros(totalRegistros);
		listDTOResponse.setMessage(getMessage("messages.response.success"));
		listDTOResponse.setDataDto(listaSedeDto);

		return listDTOResponse;
	}

	@RequestMapping(value = "/sedes/activos", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ListDTOResponse<SedeDTO>   listarTipoBasicoActivosPaginado(HttpServletRequest context) throws BusinessException {
		
		Paginador paginador = Paginador.getPagination(context);

		List<SedeDTO> listaSedeDto;
		int totalRegistros=0;
		if (paginador == null) {
			listaSedeDto = gestionarSedeBusiness.listarSedeActivos();
		}else
			listaSedeDto = gestionarSedeBusiness.listarSedeActivosPaginado(paginador.getPageSize(), paginador.getStartIndex());
				
		totalRegistros = listaSedeDto.size();
		
		listDTOResponse.setTotalRegistros(totalRegistros);
		listDTOResponse.setMessage(getMessage("messages.response.success"));
		listDTOResponse.setDataDto(listaSedeDto);

		return listDTOResponse;
	}
	
}
	
