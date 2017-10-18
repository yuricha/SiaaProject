/**
 * 
 */
package pe.infounsa.siaa.rest.controller.message;

/**
 * @author Siaa
 *
 */
public class ErrorDetail {

	private final String message;
	
	private final String detail;

	public ErrorDetail(String message) {
		this.message = message;
		this.detail = "";
	}
	
	public ErrorDetail(String message, String detail) {
		this.message = message;
		this.detail = detail;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

}
