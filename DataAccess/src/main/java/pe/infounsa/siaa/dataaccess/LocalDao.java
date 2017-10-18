package pe.infounsa.siaa.dataaccess;

import java.util.List;

import pe.infounsa.siaa.business.mantenimiento.dto.LocalAdminDTO;
import pe.infounsa.siaa.business.mantenimiento.dto.LocalDTO;

public interface LocalDao {
	
	public LocalDTO saveLocal(LocalDTO localDTO, String ip);
	public LocalDTO editLocal(LocalDTO localDTO, String ip);
	public LocalDTO getLocal(Integer codLocal);
	public LocalAdminDTO getLocalAdminMini(Integer codLocal);
	public void deleteLocal(Integer codLocal, String ip);
	public List<LocalDTO> listLocal();
	public List<LocalDTO> listLocalActivos();
	
	public LocalDTO getLocalByNombre(String nombre);
	
	//------------------------------------------ PAGINADORES --------------------------------	
	public List<LocalDTO> listLocalPaginado(Integer page, Integer limit);
	public List<LocalDTO> listLocalActivosPaginado(Integer page, Integer limit);

}
