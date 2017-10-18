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
import pe.infounsa.siaa.business.mantenimiento.GestionarTipoBasicoBusiness;
import pe.infounsa.siaa.business.mantenimiento.dto.TipoBasicoDTO;
import pe.infounsa.siaa.common.utils.Paginador;
import pe.infounsa.siaa.rest.controller.BaseController;
import pe.infounsa.siaa.rest.controller.mantenimiento.message.*;
import pe.infounsa.siaa.rest.controller.mantenimiento.validator.TipoBasicoValidator;
import pe.infounsa.siaa.rest.controller.message.RequestMessage;
import pe.infounsa.siaa.rest.controller.response.DTOResponse;
import pe.infounsa.siaa.rest.controller.response.ListDTOResponse;

@RestController
public class GestionarTipoBasicoController extends BaseController{
	
	@Autowired
	private GestionarTipoBasicoBusiness gestionarTipoBasicoBusiness;
		
	@Autowired
	private ListDTOResponse<TipoBasicoDTO> listDTOResponse;
	@Autowired
	private DTOResponse<TipoBasicoDTO> dtoResponse;
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private TipoBasicoValidator tipoBasicoValidator;
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(tipoBasicoValidator);
	}
	
	@RequestMapping(value = "/tipobasicos", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ListDTOResponse<TipoBasicoDTO> registrarTipoBasico(@RequestBody @Valid RequestMessage<ListTipoBasicoRequest> request,HttpServletRequest context) throws BusinessException {
		
		String ip = httpServletRequest.getRemoteAddr();
		
		ListTipoBasicoRequest listTipoBasicoRequest = request.getBody();
		List<TipoBasicoDTO> listaTipoBasicoDTO = gestionarTipoBasicoBusiness.guardarTipoBasico(listTipoBasicoRequest.getDataDto(), ip);
		
		listDTOResponse.setMessage(getMessage("messages.response.success"));
		listDTOResponse.setDataDto(listaTipoBasicoDTO);

		return listDTOResponse;
	}
	
	@RequestMapping(value = "/tipobasicos", method = RequestMethod.PUT, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ListDTOResponse<TipoBasicoDTO> editarTipoBasico(@RequestBody @Valid RequestMessage<ListTipoBasicoRequest> request) throws BusinessException {

		String ip = httpServletRequest.getRemoteAddr();
		
		ListTipoBasicoRequest listTipoBasicoRequest = request.getBody();		
		List<TipoBasicoDTO> listaTipoBasicoDTO = gestionarTipoBasicoBusiness.editarTipoBasico(listTipoBasicoRequest.getDataDto(), ip);

		listDTOResponse.setMessage(getMessage("messages.response.success"));
		listDTOResponse.setDataDto(listaTipoBasicoDTO);

		return listDTOResponse;
	}	
	
	@RequestMapping(value = "/tipobasicos", method = RequestMethod.DELETE, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody DTOResponse<TipoBasicoDTO> eliminarTipoBasico(@RequestBody RequestMessage<ListTipoBasicoRequest> request) throws BusinessException {

		String ip = httpServletRequest.getRemoteAddr();
		
		ListTipoBasicoRequest listTipoBasicoRequest = request.getBody();
		gestionarTipoBasicoBusiness.eliminarTipoBasico(listTipoBasicoRequest.getDataDto(), ip);
		
		dtoResponse.setMessage(getMessage("messages.response.success"));

		return dtoResponse;
	}

	
	@RequestMapping(value = "/tipobasicos/{id}", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody DTOResponse <TipoBasicoDTO> obtenerTipoBasico(@PathVariable int id) throws BusinessException {
		
		TipoBasicoDTO tipoBasicoDTO = gestionarTipoBasicoBusiness.obtenerTipoBasico(id);
		
		dtoResponse.setMessage(getMessage("messages.response.success"));
		dtoResponse.setDataDto(tipoBasicoDTO);

		return dtoResponse;
	}
	
	//------------------------------------------- PAGINADORES y Normal ---------------------------------------------------------

	@RequestMapping(value = "/tipobasicos", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ListDTOResponse<TipoBasicoDTO> listarTipoBasicoPaginado(HttpServletRequest context) throws BusinessException {

		Paginador paginador = Paginador.getPagination(context);

		List<TipoBasicoDTO> listaTipoBasicoDto;
		int totalRegistros=0;
		if (paginador == null) {
			listaTipoBasicoDto = gestionarTipoBasicoBusiness.listarTipoBasico();
		}else
			listaTipoBasicoDto = gestionarTipoBasicoBusiness.listarTipoBasicoPaginado(paginador.getPageSize(), paginador.getStartIndex());
		
		totalRegistros = listaTipoBasicoDto.size();
		
		listDTOResponse.setTotalRegistros(totalRegistros);
		listDTOResponse.setMessage(getMessage("messages.response.success"));
		listDTOResponse.setDataDto(listaTipoBasicoDto);

		return listDTOResponse;
	}

	@RequestMapping(value = "/tipobasicos/activos", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ListDTOResponse<TipoBasicoDTO>   listarTipoBasicoActivosPaginado(HttpServletRequest context) throws BusinessException {
		
		Paginador paginador =Paginador.getPagination(context);
		
		List<TipoBasicoDTO> listaTipoBasicoDto;
		int totalRegistros=0;
		if (paginador == null) {
			listaTipoBasicoDto = gestionarTipoBasicoBusiness.listarTipoBasicoActivos();
		}else
			listaTipoBasicoDto = gestionarTipoBasicoBusiness.listarTipoBasicoActivosPaginado(paginador.getPageSize(), paginador.getStartIndex());
				
		totalRegistros = listaTipoBasicoDto.size();
		
		listDTOResponse.setMessage(getMessage("messages.response.success"));
		listDTOResponse.setDataDto(listaTipoBasicoDto);
		listDTOResponse.setTotalRegistros(totalRegistros);
		
		return listDTOResponse;
	}
	
}
