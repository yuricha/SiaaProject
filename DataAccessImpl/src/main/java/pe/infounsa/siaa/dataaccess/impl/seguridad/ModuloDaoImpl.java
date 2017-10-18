/**
 * 
 */
package pe.infounsa.siaa.dataaccess.impl.seguridad;

import java.util.Date;

import org.springframework.stereotype.Component;

import pe.infounsa.siaa.business.seguridad.dto.ModuloUsuarioDto;
import pe.infounsa.siaa.business.seguridad.dto.UsuarioAdminDto;
import pe.infounsa.siaa.common.utility.Logger;
import pe.infounsa.siaa.dataaccess.seguridad.ModuloDao;

/**
 * @author Siaa
 *
 */
@Component
public class ModuloDaoImpl implements ModuloDao {

	//@Cacheable(value = "modulosUsuario", key = "#usuario.username")
	@Override
	public ModuloUsuarioDto getModulos(UsuarioAdminDto usuario) {
		// TODO implementar la recuperacion de modulos por usuario con base de
		// datos

		Logger.info(this, "Get Modulos de usuario " + usuario.getUsername());

		ModuloUsuarioDto moduloUsuario = new ModuloUsuarioDto(usuario,
				new Date());

//		for (PerfilDto perfil : usuario.getAuthorities()) {
//			if (perfil.getRol() == RolSistema.ADMINISTRADOR) {
//				moduloUsuario.addModulo("ADM");
//				moduloUsuario.addModulo("ALM");
//				moduloUsuario.addModulo("COC");
//				moduloUsuario.addModulo("FAC");
//				moduloUsuario.addModulo("PED");
//			} else if (perfil.getRol() == RolSistema.CAJERO) {
//				moduloUsuario.addModulo("FAC");
//				moduloUsuario.addModulo("PED");
//			} else if (perfil.getRol() == RolSistema.COCINERO) {
//				moduloUsuario.addModulo("ALM");
//				moduloUsuario.addModulo("COC");
//				moduloUsuario.addModulo("PED");
//			} else if (perfil.getRol() == RolSistema.MOZO) {
//				moduloUsuario.addModulo("COC");
//				moduloUsuario.addModulo("PED");
//			}
//		}
		
		moduloUsuario.addModulo("ADM");
		moduloUsuario.addModulo("ALM");
		moduloUsuario.addModulo("COC");
		moduloUsuario.addModulo("FAC");
		moduloUsuario.addModulo("MAN");

		return moduloUsuario;
	}
}
