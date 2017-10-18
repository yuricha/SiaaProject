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
import pe.infounsa.siaa.business.mantenimiento.GestionarLocalBusiness;
import pe.infounsa.siaa.business.mantenimiento.dto.LocalDTO;
import pe.infounsa.siaa.common.utils.Paginador;
import pe.infounsa.siaa.rest.controller.BaseController;
import pe.infounsa.siaa.rest.controller.mantenimiento.message.ListLocalRequest;
import pe.infounsa.siaa.rest.controller.mantenimiento.validator.LocalValidator;
import pe.infounsa.siaa.rest.controller.message.RequestMessage;
import pe.infounsa.siaa.rest.controller.response.DTOResponse;
import pe.infounsa.siaa.rest.controller.response.ListDTOResponse;

@RestController
public class GestionarLocalController extends BaseController{

	@Autowired
	private GestionarLocalBusiness gestionarLocalBusiness;
	
	@Autowired
	private ListDTOResponse<LocalDTO> listDTOResponse;
	@Autowired
	private DTOResponse<LocalDTO> dtoResponse;
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private LocalValidator localValidator;
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(localValidator);
	}
	
	@RequestMapping(value = "/locales", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ListDTOResponse<LocalDTO> registrarLocal(@RequestBody @Valid RequestMessage<ListLocalRequest> request) throws BusinessException {
		
		String ip = httpServletRequest.getRemoteAddr();
		
		ListLocalRequest listLocalRequest = request.getBody();
		List<LocalDTO> listaLocalDTO = gestionarLocalBusiness.guardarLocal(listLocalRequest.getDataDto(), ip);
		
		listDTOResponse.setMessage(getMessage("messages.response.success"));
		listDTOResponse.setDataDto(listaLocalDTO);

		return listDTOResponse;
	}
	
	@RequestMapping(value = "/locales", method = RequestMethod.PUT, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ListDTOResponse<LocalDTO> editarLocal(@RequestBody @Valid RequestMessage<ListLocalRequest> request) throws BusinessException {
				
		String ip = httpServletRequest.getRemoteAddr();
		
		ListLocalRequest listLocalRequest = request.getBody();
		List<LocalDTO> listaLocalDTO = gestionarLocalBusiness.editarLocal(listLocalRequest.getDataDto(), ip);
		
		listDTOResponse.setMessage(getMessage("messages.response.success"));
		listDTOResponse.setDataDto(listaLocalDTO);

		return listDTOResponse;
	}	
	
	@RequestMapping(value = "/locales", method = RequestMethod.DELETE, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ListDTOResponse<LocalDTO> eliminarLocal(@RequestBody RequestMessage<ListLocalRequest> request) throws BusinessException {
								 
		String ip = httpServletRequest.getRemoteAddr();
		
		ListLocalRequest listLocalRequest = request.getBody();
		gestionarLocalBusiness.eliminarLocal(listLocalRequest.getDataDto(), ip);
		
		listDTOResponse.setMessage(getMessage("messages.response.success"));

		return listDTOResponse;
	}
			
	@RequestMapping(value = "/locales/{id}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody DTOResponse<LocalDTO> obtenerLocal(@PathVariable int id) throws BusinessException {
		
		LocalDTO localDTO = gestionarLocalBusiness.obtenerLocal(id);
		
		dtoResponse.setMessage(getMessage("messages.response.success"));
		dtoResponse.setDataDto(localDTO);

		return dtoResponse;
	}
	
	//------------------------------------------- PAGINADORES y Normal ---------------------------------------------------------

	@RequestMapping(value = "/locales", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ListDTOResponse<LocalDTO> listarTipoBasicoPaginado(HttpServletRequest context) throws BusinessException {
	
		Paginador paginador = Paginador.getPagination(context);
		List<LocalDTO> listaLocalDto;
		int totalRegistros=0;
		if (paginador == null) {
			listaLocalDto = gestionarLocalBusiness.listarLocal();
		}else
			listaLocalDto = gestionarLocalBusiness.listarLocalPaginado(paginador.getPageSize(), paginador.getStartIndex());
		
		totalRegistros = listaLocalDto.size();
		
		listDTOResponse.setTotalRegistros(totalRegistros);
		listDTOResponse.setMessage(getMessage("messages.response.success"));
		listDTOResponse.setDataDto(listaLocalDto);
		
		return listDTOResponse;
	}

	@RequestMapping(value = "/locales/activos", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ListDTOResponse<LocalDTO>   listarTipoBasicoActivosPaginado(HttpServletRequest context) throws BusinessException {
			
		Paginador paginador =Paginador.getPagination(context);
		
		List<LocalDTO> listaLocalDto;
		int totalRegistros=0;
		if (paginador == null) {
			listaLocalDto = gestionarLocalBusiness.listarLocalActivos();
		}else
			listaLocalDto = gestionarLocalBusiness.listarLocalActivosPaginado(paginador.getPageSize(), paginador.getStartIndex());
				
		totalRegistros = listaLocalDto.size();
		
		listDTOResponse.setMessage(getMessage("messages.response.success"));
		listDTOResponse.setDataDto(listaLocalDto);
		listDTOResponse.setTotalRegistros(totalRegistros);
		
		return listDTOResponse;
	}
	
}
