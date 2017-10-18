/**
 * 
 */
package pe.infounsa.siaa.rest.controller.seguridad.message;

import java.util.Date;

import pe.infounsa.siaa.rest.controller.message.ResponseBody;

/**
 * @author Siaa
 *
 */
public class LogoutResponse extends ResponseBody {

	private String status;

	private Date lastLogout;

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
	 * @return the lastLogout
	 */
	public Date getLastLogout() {
		return lastLogout;
	}

	/**
	 * @param lastLogout
	 *            the lastLogout to set
	 */
	public void setLastLogout(Date lastLogout) {
		this.lastLogout = lastLogout;
	}

}
