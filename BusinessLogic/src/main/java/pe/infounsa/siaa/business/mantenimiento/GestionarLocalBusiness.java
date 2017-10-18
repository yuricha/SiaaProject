package pe.infounsa.siaa.business.mantenimiento;

import java.util.List;

import pe.infounsa.siaa.business.exception.BusinessException;
import pe.infounsa.siaa.business.mantenimiento.dto.LocalDTO;

public interface GestionarLocalBusiness {
	
	public List<LocalDTO> guardarLocal(List<LocalDTO> listaLocalDTO, String ip) throws BusinessException;
	public List<LocalDTO> editarLocal(List<LocalDTO> listaLocalDTO, String ip) throws BusinessException;
	public LocalDTO obtenerLocal(Integer codLocal);
	public void eliminarLocal(List<LocalDTO> listaLocalDto, String ip);
	public List<LocalDTO> listarLocal();
	public List<LocalDTO> listarLocalActivos();
	//------------------------------ PAGINADORES ---------------------------------------
	public List<LocalDTO> listarLocalPaginado(Integer page, Integer limit);
	public List<LocalDTO> listarLocalActivosPaginado(Integer page, Integer limit);

}
