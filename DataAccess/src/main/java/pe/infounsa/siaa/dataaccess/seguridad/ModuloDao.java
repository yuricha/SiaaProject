/**
 * 
 */
package pe.infounsa.siaa.dataaccess.seguridad;

import pe.infounsa.siaa.business.seguridad.dto.ModuloUsuarioDto;
import pe.infounsa.siaa.business.seguridad.dto.UsuarioAdminDto;

/**
 * @author Siaa
 *
 */
public interface ModuloDao {

	public ModuloUsuarioDto getModulos(UsuarioAdminDto usuario);
}
