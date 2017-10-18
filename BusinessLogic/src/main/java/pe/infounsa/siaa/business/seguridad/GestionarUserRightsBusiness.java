/**
 * 
 */
package pe.infounsa.siaa.business.seguridad;

import org.springframework.security.core.userdetails.UserDetails;

import pe.infounsa.siaa.common.seguridad.ModuloSistema;

/**
 * @author
 *
 */
public interface GestionarUserRightsBusiness {

	public boolean hasPermissionRight(UserDetails user,String permission);
	//public boolean hasPermissionRight(UserDetails user, ModuloSistema modulo,String permission);

	public boolean hasModuleRight(UserDetails user, ModuloSistema module); 
}
