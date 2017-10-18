package pe.infounsa.siaa.business.mantenimiento;

import java.util.List;

import pe.infounsa.siaa.business.exception.BusinessException;
import pe.infounsa.siaa.business.mantenimiento.dto.SedeDTO;

public interface GestionarSedeBusiness {

	public List<SedeDTO> guardarSede(List<SedeDTO> listaSedeDTO, String ip) throws BusinessException;
	public List<SedeDTO> editarSede(List<SedeDTO> listaSedeDTO, String ip) throws BusinessException;
	public SedeDTO obtenerSede(Integer codSede);
	public void eliminarSede(List<SedeDTO> listaSedeDTO, String ip);
	public List<SedeDTO> listarSede();
	public List<SedeDTO> listarSedeActivos();
	//------------------------------ PAGINADORES ---------------------------------------
	public List<SedeDTO> listarSedePaginado(Integer page, Integer limit);
	public List<SedeDTO> listarSedeActivosPaginado(Integer page, Integer limit);
	
}
