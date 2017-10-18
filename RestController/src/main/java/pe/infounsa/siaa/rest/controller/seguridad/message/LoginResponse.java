/**
 * 
 */
package pe.infounsa.siaa.rest.controller.seguridad.message;

import java.util.Date;

import pe.infounsa.siaa.business.seguridad.dto.UsuarioAdminDto;
import pe.infounsa.siaa.rest.controller.message.ResponseBody;

/**
 * @author
 *
 */
public class LoginResponse extends ResponseBody {

	private UsuarioAdminDto username;

	private String status;
	
	private Date lastLogin;

	/**
	 * @return the username
	 */
	public UsuarioAdminDto getUsername() {
		return username;
	}

	public void setUsername(UsuarioAdminDto username) {
		this.username = username;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the lastLogin
	 */
	public Date getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin
	 *            the lastLogin to set
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

}
