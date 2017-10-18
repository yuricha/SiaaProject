package pe.infounsa.siaa.business.mantenimiento;

import java.util.List;

import pe.infounsa.siaa.business.exception.BusinessException;
import pe.infounsa.siaa.business.mantenimiento.dto.TipoBasicoDTO;

public interface GestionarTipoBasicoBusiness {
	
	public List<TipoBasicoDTO> guardarTipoBasico(List<TipoBasicoDTO> listaTipoBasicoDTO, String ip) throws BusinessException;
	public List<TipoBasicoDTO> editarTipoBasico(List<TipoBasicoDTO> listaTipoBasicoDTO, String ip) throws BusinessException;
	public TipoBasicoDTO obtenerTipoBasico(Integer codTipoBasico);
	public void eliminarTipoBasico(List<TipoBasicoDTO> listaTipoBasicoDTO, String ip);
	public List<TipoBasicoDTO> listarTipoBasico();
	public List<TipoBasicoDTO> listarTipoBasicoActivos();
	//------------------------------ PAGINADORES ---------------------------------------
	public List<TipoBasicoDTO> listarTipoBasicoPaginado(Integer page, Integer limit);
	public List<TipoBasicoDTO> listarTipoBasicoActivosPaginado(Integer page, Integer limit);
	
}
