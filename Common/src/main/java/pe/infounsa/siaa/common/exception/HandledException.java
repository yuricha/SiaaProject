/**
 * 
 */
package pe.infounsa.siaa.common.exception;

/**
 * @author Siaa
 *
 */
@SuppressWarnings("serial")
public abstract class HandledException extends Exception {

	public HandledException(String message) {
		super(message);
		// Log.error(this, "Exception[" + message + "]");
	}

	public HandledException(String message, Exception e) {
		super(message);

		// Log.error(this, message + " Exception[" + e.getMessage() + "]");
	}
}
