/**
 * 
 */
package pe.infounsa.siaa.dataaccess.impl.seguridad;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.infounsa.siaa.business.seguridad.dto.PerfilDto;
import pe.infounsa.siaa.business.seguridad.dto.PermisoUsuarioDto;
import pe.infounsa.siaa.common.utility.Logger;
import pe.infounsa.siaa.dataaccess.seguridad.PermisoDao;
//import pe.infounsa.siaa.repository.persistence.PerfilPermisoRepository;

/**
 * @author 
 *
 */
// @Cacheable
@Component 
public class PermisoDaoImpl implements PermisoDao {

//	@Autowired
//	private PerfilPermisoRepository perfilPermisoRepository;
	
	@Override
//	@Cacheable(value = "permisosUsuario", key = "#perfilUsuario.nombre")
	public PermisoUsuarioDto getPermisos(PerfilDto perfilUsuario) {

		PermisoUsuarioDto permisoUsuario = new PermisoUsuarioDto(null,new Date());

		Logger.info(this, "Get Permisos de usuario perfil "+ perfilUsuario.getNombre());

//		List<String> permisos = perfilPermisoRepository.getListPermisosPerfil(perfilUsuario.getCodigo());
//		
//		if(permisos != null && !permisos.isEmpty())
//		for(String permiso : permisos){
//			
//			permisoUsuario.addPermiso(permiso);
//		}
		
		
//		for (ModuloSistema modulo : moduloUsuario.getModulos()) {
//
//			if (modulo == ModuloSistema.ADMINISTRACION) {
//				permisoUsuario.addPermiso(ModuloSistema.ADMINISTRACION,"generarNuevoPedido");
//				// permisoUsuario.addPermiso(modulo, "C_USUARIO");
//			} else if (modulo == ModuloSistema.PEDIDOS) {
//				permisoUsuario.addPermiso(ModuloSistema.PEDIDOS,"generarNuevoPedido");
//				// permisoUsuario.addPermiso(modulo, "C_PEDIDO");
//			}
//		}

		return permisoUsuario;
	}

}
