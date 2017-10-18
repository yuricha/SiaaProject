/**
 * 
 */
package pe.infounsa.siaa.business.impl.seguridad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import pe.infounsa.siaa.business.seguridad.GestionarUserRightsBusiness;
import pe.infounsa.siaa.business.seguridad.dto.ModuloUsuarioDto;
import pe.infounsa.siaa.business.seguridad.dto.PermisoUsuarioDto;
import pe.infounsa.siaa.business.seguridad.dto.UsuarioAdminDto;
import pe.infounsa.siaa.common.seguridad.ModuloSistema;
import pe.infounsa.siaa.dataaccess.seguridad.ModuloDao;
import pe.infounsa.siaa.dataaccess.seguridad.PermisoDao;

/**
 * @author
 *
 */
@Service
public class GestionarUserRightsBusinessImpl implements	GestionarUserRightsBusiness {
 
	@Autowired
	private ModuloDao moduloDao;

	@Autowired
	private PermisoDao permisoDao;

	@Override
	public boolean hasPermissionRight(UserDetails user,String permission) {
		// TODO Auto-generated method stub

		boolean hasAccesss = false;
		
		//ModuloUsuarioDto moduloUsuario = moduloDao.getModulos((UsuarioAdminDto) user);
		
		UsuarioAdminDto usuario = (UsuarioAdminDto) user;
		
		if(usuario.getPerfil() != null){
			
		PermisoUsuarioDto permisoUsuario = permisoDao.getPermisos(usuario.getPerfil());
		
		List<String> permisos = permisoUsuario.getPermisos();

		if (permisos != null) {

			for (String permiso : permisos) {
				if (permiso.equalsIgnoreCase(permission)) {
					hasAccesss = true;
					break;
				}
			}
		}
		}

		return hasAccesss;
	}

	@Override
	public boolean hasModuleRight(UserDetails user, ModuloSistema module) {
		// TODO Auto-generated method stub
		boolean hasAccesss = false;
		ModuloUsuarioDto moduloUsuario = moduloDao
				.getModulos((UsuarioAdminDto) user);

		List<ModuloSistema> modulos = moduloUsuario.getModulos();

		if (modulos != null) {

			for (ModuloSistema modulo : modulos) {
				if (modulo == module) {
					hasAccesss = true;
					break;
				}
			}
		}

		return hasAccesss;
	}

}
