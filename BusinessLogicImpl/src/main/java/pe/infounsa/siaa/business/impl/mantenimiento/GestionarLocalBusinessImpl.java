package pe.infounsa.siaa.business.impl.mantenimiento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.infounsa.siaa.business.exception.BusinessException;
import pe.infounsa.siaa.business.mantenimiento.GestionarLocalBusiness;
import pe.infounsa.siaa.business.mantenimiento.dto.LocalDTO;
import pe.infounsa.siaa.business.mantenimiento.exception.LocalException;
import pe.infounsa.siaa.dataaccess.LocalDao;

@Service
public class GestionarLocalBusinessImpl implements GestionarLocalBusiness{
	
	@Autowired
	private LocalDao localDao;

	@Override
	public synchronized List<LocalDTO> guardarLocal(List<LocalDTO> listaLocalDTO, String ip) throws BusinessException{
		// TODO Auto-generated method stub
		
		if(listaLocalDTO!=null){
			for(LocalDTO localDTO : listaLocalDTO){
											
				localDTO.setIid(0);
				this.formatoLocal(localDTO);
				this.validacionLocal(localDTO);
				
				localDTO = localDao.saveLocal(localDTO, ip);
			}
		}
		
		return listaLocalDTO;
	}

	@Override
	public synchronized List<LocalDTO> editarLocal(List<LocalDTO> listaLocalDTO, String ip) throws BusinessException{
		// TODO Auto-generated method stub
		
		if(listaLocalDTO!=null){
			for(LocalDTO localDTO : listaLocalDTO){
				
				if(localDTO.getIid()<0 || localDTO.getIid()==0)
					break;
				
				this.formatoLocal(localDTO);
				this.validacionLocal(localDTO);
				
				localDTO = localDao.editLocal(localDTO, ip);
				
			}
		}
		
		return listaLocalDTO;
	}

	@Override
	public synchronized LocalDTO obtenerLocal(Integer codLocal) {
		// TODO Auto-generated method stub
		return localDao.getLocal(codLocal);
	}

	@Override
	public synchronized void eliminarLocal(List<LocalDTO> listaLocalDTO, String ip) {
		// TODO Auto-generated method stub
		
		if(listaLocalDTO!=null){
			for(LocalDTO localDTO : listaLocalDTO){
				localDao.deleteLocal(localDTO.getIid(), ip);
			}
		}
		
	}

	@Override
	public synchronized List<LocalDTO> listarLocal() {
		// TODO Auto-generated method stub
		return localDao.listLocal();
	}

	@Override
	public synchronized List<LocalDTO> listarLocalActivos() {
		// TODO Auto-generated method stub
		return localDao.listLocalActivos();
	}
	
	//-------------------------------- PAGINADORES --------------------------------------------
	@Override
	public List<LocalDTO> listarLocalPaginado(Integer page, Integer limit) {
		// TODO Auto-generated method stub
		return localDao.listLocalPaginado(page, limit);
	}

	@Override
	public List<LocalDTO> listarLocalActivosPaginado(Integer page, Integer limit) {
		// TODO Auto-generated method stub
		return localDao.listLocalActivosPaginado(page, limit);
	}
	//-----------------------------------------------------------------------------------------
	private LocalDTO formatoLocal(LocalDTO localDTO){
		
		if(localDTO.getVcodigocoordinador()!=null)
			localDTO.setVcodigocoordinador(localDTO.getVcodigocoordinador().trim().toUpperCase());
		if(localDTO.getVdireccion()!=null)
			localDTO.setVdireccion(localDTO.getVdireccion().trim().toUpperCase());
		if(localDTO.getVnombre()!=null)
			localDTO.setVnombre(localDTO.getVnombre().trim().toUpperCase());
		if(localDTO.getVtelefono()!=null)
			localDTO.setVtelefono(localDTO.getVtelefono().trim());
		
		if(localDTO.getBhabilitado()==null)
			localDTO.setBhabilitado((boolean)true);
		
		return localDTO;
	}
	
	private LocalDTO validacionLocal(LocalDTO localDTO) throws BusinessException{
		
		if(localDTO.getIid()==0){//Nuevo
			
			if(localDao.getLocalByNombre(localDTO.getVnombre())!=null)
				throw new LocalException("001","exception.local.vnombre.duplicado");
			
		}else{//Editar
			
			LocalDTO localAnteriorDTO;
			
			localAnteriorDTO = localDao.getLocalByNombre(localDTO.getVnombre());
			if(localAnteriorDTO!=null)
				if(localAnteriorDTO.getIid() != localDTO.getIid())
					throw new LocalException("002","exception.local.vnombre.duplicado");
			
		}			
		
		return localDTO;
	}

}
