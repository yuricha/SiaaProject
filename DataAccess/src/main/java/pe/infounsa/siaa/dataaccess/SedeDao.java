package pe.infounsa.siaa.dataaccess;

import java.util.List;

import pe.infounsa.siaa.business.mantenimiento.dto.SedeAdminDTO;
import pe.infounsa.siaa.business.mantenimiento.dto.SedeDTO;

public interface SedeDao {

	public SedeDTO saveSede(SedeDTO sedeDTO, String ip);
	public SedeDTO editSede(SedeDTO sedeDTO, String ip);
	public SedeDTO getSede(Integer codSede);
	public SedeAdminDTO getSedeAdminMini(Integer codSede);
	public void deleteSede(Integer codSede, String ip);
	public List<SedeDTO> listSede();
	public List<SedeDTO> listSedeActivos();
	
	public SedeDTO getSedeByNombre(String nombre);
	
	//------------------------------------------ PAGINADORES --------------------------------	
	public List<SedeDTO> listSedePaginado(Integer page, Integer limit);
	public List<SedeDTO> listSedeActivosPaginado(Integer page, Integer limit);
	
}
