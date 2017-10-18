package pe.infounsa.siaa.business.impl.mantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.infounsa.siaa.business.exception.BusinessException;
import pe.infounsa.siaa.business.mantenimiento.GestionarSedeBusiness;
import pe.infounsa.siaa.business.mantenimiento.dto.SedeDTO;
import pe.infounsa.siaa.business.mantenimiento.exception.SedeException;
import pe.infounsa.siaa.dataaccess.SedeDao;

@Service
public class GestionarSedeBusinessImpl implements GestionarSedeBusiness{
	
	@Autowired
	private SedeDao sedeDao;

	@Override
	public synchronized List<SedeDTO> guardarSede(List<SedeDTO> listaSedeDTO, String ip) throws BusinessException{
		// TODO Auto-generated method stub
		
		if(listaSedeDTO!=null){
			for(SedeDTO sedeDTO : listaSedeDTO){
											
				sedeDTO.setIid(0);
				this.formatoSede(sedeDTO);
				this.validacionSede(sedeDTO);
				
				sedeDTO = sedeDao.saveSede(sedeDTO, ip);
			}
		}
		
		return listaSedeDTO;		
	}

	@Override
	public synchronized List<SedeDTO> editarSede(List<SedeDTO> listaSedeDTO, String ip) throws BusinessException{
		// TODO Auto-generated method stub
		
		if(listaSedeDTO!=null){
			for(SedeDTO sedeDTO : listaSedeDTO){
				
				if(sedeDTO.getIid()<0 || sedeDTO.getIid()==0)
					break;
				
				this.formatoSede(sedeDTO);
				this.validacionSede(sedeDTO);
				
				sedeDTO = sedeDao.editSede(sedeDTO, ip);
				
			}
		}
		
		return listaSedeDTO;
	}

	@Override
	public synchronized SedeDTO obtenerSede(Integer codSede) {
		// TODO Auto-generated method stub
		return sedeDao.getSede(codSede);
	}

	@Override
	public synchronized void eliminarSede(List<SedeDTO> listaSedeDTO, String ip) {
		// TODO Auto-generated method stub
		
		if(listaSedeDTO!=null){
			for(SedeDTO sedeDTO : listaSedeDTO){
				sedeDao.deleteSede(sedeDTO.getIid(), ip);
			}
		}
	}

	@Override
	public synchronized List<SedeDTO> listarSede() {
		// TODO Auto-generated method stub
		return sedeDao.listSede();
	}

	@Override
	public synchronized List<SedeDTO> listarSedeActivos() {
		// TODO Auto-generated method stub
		return sedeDao.listSedeActivos();
	}
	
	//-------------------------------- PAGINADORES --------------------------------------------
	@Override
	public List<SedeDTO> listarSedePaginado(Integer page, Integer limit) {
		// TODO Auto-generated method stub
		return sedeDao.listSedePaginado(page, limit);
	}

	@Override
	public List<SedeDTO> listarSedeActivosPaginado(Integer page, Integer limit) {
		// TODO Auto-generated method stub
		return sedeDao.listSedeActivosPaginado(page, limit);
	}
	//-----------------------------------------------------------------------------------------
	private SedeDTO formatoSede(SedeDTO sedeDTO){
		
		if(sedeDTO.getVcodigoadministrador()!=null)
			sedeDTO.setVcodigoadministrador(sedeDTO.getVcodigoadministrador().trim().toUpperCase());
		if(sedeDTO.getVnombre()!=null)
			sedeDTO.setVnombre(sedeDTO.getVnombre().trim().toUpperCase());
		
		if(sedeDTO.getBhabilitado()==null)
			sedeDTO.setBhabilitado((boolean)true);
		
		return sedeDTO;
	}
	
	private SedeDTO validacionSede(SedeDTO sedeDTO) throws BusinessException{
		
		if(sedeDTO.getIid()==0){//Nuevo
			
			if(sedeDao.getSedeByNombre(sedeDTO.getVnombre())!=null)
				throw new SedeException("001","exception.sede.vnombre.duplicado");
			
		}else{//Editar
			
			SedeDTO sedeAnteriorDTO;
			
			sedeAnteriorDTO = sedeDao.getSedeByNombre(sedeDTO.getVnombre());
			if(sedeAnteriorDTO!=null)
				if(sedeAnteriorDTO.getIid() != sedeDTO.getIid())
					throw new SedeException("002","exception.sede.vnombre.duplicado");
			
		}
		
		return sedeDTO;
	}

}
