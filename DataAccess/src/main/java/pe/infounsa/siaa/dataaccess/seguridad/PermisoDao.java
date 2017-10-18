/**
 * 
 */
package pe.infounsa.siaa.dataaccess.seguridad;

import pe.infounsa.siaa.business.seguridad.dto.PerfilDto;
import pe.infounsa.siaa.business.seguridad.dto.PermisoUsuarioDto;

/**
 * @author
 *
 */
public interface PermisoDao {
	
	public PermisoUsuarioDto getPermisos(PerfilDto perfilUsuario);

}
