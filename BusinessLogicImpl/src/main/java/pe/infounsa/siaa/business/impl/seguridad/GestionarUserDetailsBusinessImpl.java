/**
 * 
 */
package pe.infounsa.siaa.business.impl.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.infounsa.siaa.business.seguridad.GestionarUserDetailsBusiness;
import pe.infounsa.siaa.dataaccess.seguridad.UsuarioDao;

/**
 * @author 
 *
 */
@Service
public class GestionarUserDetailsBusinessImpl implements GestionarUserDetailsBusiness {
 
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		UserDetails userDetails = usuarioDao.getUsuarioAdminByName(username);

		if (userDetails == null) {
			throw new UsernameNotFoundException("exception.UserDetails.usuario.existe");
		}

		return userDetails;
	}

}
