package pe.infounsa.siaa.dataaccess;

import java.util.List;

import pe.infounsa.siaa.business.mantenimiento.dto.TipoBasicoAdminDTO;
import pe.infounsa.siaa.business.mantenimiento.dto.TipoBasicoDTO;

public interface TipoBasicoDao {

	public TipoBasicoDTO saveTipoBasico(TipoBasicoDTO tipoBasicoDTO, String ip);
	public TipoBasicoDTO editTipoBasico(TipoBasicoDTO tipoBasicoDTO, String ip);
	public TipoBasicoDTO getTipoBasico(Integer codTipoBasico);
	public TipoBasicoAdminDTO getTipoBasicoAdminMini(Integer codTipoBasico);
	public void deleteTipoBasico(Integer codTipoBasico, String ip);
	public List<TipoBasicoDTO> listTipoBasico();
	public List<TipoBasicoDTO> listTipoBasicoActivos();
	
	public TipoBasicoDTO getTipoBasicoByCodigo(String codigo, Integer codPadre);
	public TipoBasicoDTO getTipoBasicoByNombre(String nombre, Integer codPadre);
	public TipoBasicoDTO getTipoBasicoByAbreviatura(String abreviatura, Integer codPadre);
		
	//------------------------------------------ PAGINADORES --------------------------------	
	public List<TipoBasicoDTO> listTipoBasicoPaginado(Integer page, Integer limit);
	public List<TipoBasicoDTO> listTipoBasicoActivosPaginado(Integer page, Integer limit);
	/**/
}