/**
 * 
 */
package pe.infounsa.siaa.business.exception;

/**
 * @author Siaa
 *
 */
@SuppressWarnings("serial")
public class GenericBusinessException extends BusinessException {

	public GenericBusinessException(String code, String message) {
		super(code, message);
	}

	public GenericBusinessException(String code, String message,
			Exception exception) {
		super(code, message, exception);
	}

}
