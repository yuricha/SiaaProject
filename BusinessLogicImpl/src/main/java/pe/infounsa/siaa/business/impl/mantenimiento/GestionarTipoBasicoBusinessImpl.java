package pe.infounsa.siaa.business.impl.mantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.infounsa.siaa.business.exception.BusinessException;
import pe.infounsa.siaa.business.mantenimiento.GestionarTipoBasicoBusiness;
import pe.infounsa.siaa.business.mantenimiento.dto.TipoBasicoDTO;
import pe.infounsa.siaa.business.mantenimiento.exception.TipoBasicoException;
import pe.infounsa.siaa.dataaccess.TipoBasicoDao;

@Service
public class GestionarTipoBasicoBusinessImpl implements GestionarTipoBasicoBusiness{
	
	@Autowired
	private TipoBasicoDao tipoBasicoDao;

	@Override
	public synchronized List<TipoBasicoDTO> guardarTipoBasico(List<TipoBasicoDTO> listaTipoBasicoDTO, String ip) throws BusinessException{
		// TODO Auto-generated method stub
		
		if(listaTipoBasicoDTO!=null){
			for(TipoBasicoDTO tipoBasicoDTO : listaTipoBasicoDTO){
											
				tipoBasicoDTO.setIid(0);
				this.formatoTipoBasico(tipoBasicoDTO);
				this.validacionTipoBasico(tipoBasicoDTO);
				
				tipoBasicoDTO = tipoBasicoDao.saveTipoBasico(tipoBasicoDTO, ip);
			}
		}
		
		return listaTipoBasicoDTO;
		
	}

	@Override
	public synchronized List<TipoBasicoDTO> editarTipoBasico(List<TipoBasicoDTO> listaTipoBasicoDTO, String ip) throws BusinessException{
		// TODO Auto-generated method stub
		
		if(listaTipoBasicoDTO!=null){
			for(TipoBasicoDTO tipoBasicoDTO : listaTipoBasicoDTO){
				
				if(tipoBasicoDTO.getIid()<0 || tipoBasicoDTO.getIid()==0)
					break;
				
				this.formatoTipoBasico(tipoBasicoDTO);
				this.validacionTipoBasico(tipoBasicoDTO);
				
				tipoBasicoDTO = tipoBasicoDao.editTipoBasico(tipoBasicoDTO, ip);
				
			}
		}
		
		return listaTipoBasicoDTO;
	}
	
	@Override
	public synchronized TipoBasicoDTO obtenerTipoBasico(Integer codTipoBasico){
		return tipoBasicoDao.getTipoBasico(codTipoBasico);
	}

	@Override
	public synchronized void eliminarTipoBasico(List<TipoBasicoDTO> listaTipoBasicoDTO, String ip) {
		// TODO Auto-generated method stub
		
		if(listaTipoBasicoDTO!=null){
			for(TipoBasicoDTO tipoBasicoDTO : listaTipoBasicoDTO){
				tipoBasicoDao.deleteTipoBasico(tipoBasicoDTO.getIid(), ip);
			}
		}
		
	}


	@Override
	public synchronized List<TipoBasicoDTO> listarTipoBasico() {
		// TODO Auto-generated method stub
		return tipoBasicoDao.listTipoBasico();
	}
	/**/

	@Override
	public synchronized List<TipoBasicoDTO> listarTipoBasicoActivos() {
		// TODO Auto-generated method stub
		return tipoBasicoDao.listTipoBasicoActivos();
	}
	
	//-------------------------------- PAGINADORES --------------------------------------------
	@Override
	public List<TipoBasicoDTO> listarTipoBasicoPaginado(Integer page, Integer limit) {
		// TODO Auto-generated method stub
		return tipoBasicoDao.listTipoBasicoPaginado(page, limit);
	}

	@Override
	public List<TipoBasicoDTO> listarTipoBasicoActivosPaginado(Integer page, Integer limit) {
		// TODO Auto-generated method stub
		return tipoBasicoDao.listTipoBasicoActivosPaginado(page, limit);
	}
	//-----------------------------------------------------------------------------------------
	private TipoBasicoDTO formatoTipoBasico(TipoBasicoDTO tipoBasicoDTO){
		
		if(tipoBasicoDTO.getVabreviatura()!=null)
			tipoBasicoDTO.setVabreviatura(tipoBasicoDTO.getVabreviatura().trim().toUpperCase());
		if(tipoBasicoDTO.getVcodigo()!=null)
			tipoBasicoDTO.setVcodigo(tipoBasicoDTO.getVcodigo().trim().toUpperCase());
		if(tipoBasicoDTO.getVnombre()!=null)
			tipoBasicoDTO.setVnombre(tipoBasicoDTO.getVnombre().trim().toUpperCase());
		if(tipoBasicoDTO.getVobservacion()!=null)
			tipoBasicoDTO.setVobservacion(tipoBasicoDTO.getVobservacion().trim());
		if(tipoBasicoDTO.getVtipo()!=null)
			tipoBasicoDTO.setVtipo(tipoBasicoDTO.getVtipo().trim().toUpperCase());
		
		if(tipoBasicoDTO.getBhabilitado()==null)
			tipoBasicoDTO.setBhabilitado((boolean)true);
			
		return tipoBasicoDTO;
	}
	
	private TipoBasicoDTO validacionTipoBasico(TipoBasicoDTO tipoBasicoDTO) throws BusinessException{
		
		if(tipoBasicoDTO.getIid()==0){//Nuevo
			
			if(tipoBasicoDao.getTipoBasicoByCodigo(tipoBasicoDTO.getVcodigo(), tipoBasicoDTO.getIidpadre())!=null)
				throw new TipoBasicoException("001","exception.vcodigo.duplicado");
			
			if(tipoBasicoDao.getTipoBasicoByNombre(tipoBasicoDTO.getVnombre(), tipoBasicoDTO.getIidpadre())!=null)
				throw new TipoBasicoException("002","exception.tipobasico.vnombre.duplicado");
			
			if(tipoBasicoDao.getTipoBasicoByAbreviatura(tipoBasicoDTO.getVabreviatura(), tipoBasicoDTO.getIidpadre())!=null)
				throw new TipoBasicoException("003","exception.tipobasico.vabreviatura.duplicado");
							
		}else{//Editar
			
			TipoBasicoDTO tipoBasicoAnteriorDTO;
			
			tipoBasicoAnteriorDTO = tipoBasicoDao.getTipoBasicoByCodigo(tipoBasicoDTO.getVcodigo(), tipoBasicoDTO.getIidpadre());
			if(tipoBasicoAnteriorDTO!=null)
				if(tipoBasicoAnteriorDTO.getIid() != tipoBasicoDTO.getIid())
					throw new TipoBasicoException("004","exception.tipobasico.vcodigo.duplicado");
			
			tipoBasicoAnteriorDTO = tipoBasicoDao.getTipoBasicoByNombre(tipoBasicoDTO.getVnombre(), tipoBasicoDTO.getIidpadre());
			if(tipoBasicoAnteriorDTO!=null)
				if(tipoBasicoAnteriorDTO.getIid() != tipoBasicoDTO.getIid())
					throw new TipoBasicoException("005","exception.tipobasico.vnombre.duplicado");
			
			tipoBasicoAnteriorDTO = tipoBasicoDao.getTipoBasicoByAbreviatura(tipoBasicoDTO.getVabreviatura(), tipoBasicoDTO.getIidpadre());
			if(tipoBasicoAnteriorDTO!=null)
				if(tipoBasicoAnteriorDTO.getIid() != tipoBasicoDTO.getIid())
					throw new TipoBasicoException("006","exception.tipobasico.vabreviatura.duplicado");
			
		}
		
		return tipoBasicoDTO;
	}



}
