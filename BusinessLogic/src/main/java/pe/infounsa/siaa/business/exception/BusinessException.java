/**
 * 
 */
package pe.infounsa.siaa.business.exception;

import pe.infounsa.siaa.common.exception.HandledException;

/**
 * @author Siaa
 *
 */
@SuppressWarnings("serial")
public abstract class BusinessException extends HandledException {

	private final String errorCode;
	
	public BusinessException(String code, String message) {
		super(message);
		this.errorCode = code;
		// Log.error(this, "Exception[" + code + "] " + message);
	}

	public BusinessException(String code, String message, Exception exception) {
		super(message, exception);
		this.errorCode = code;
		// Log.error(this, "Exception[" + code + "] " + message);
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

}
