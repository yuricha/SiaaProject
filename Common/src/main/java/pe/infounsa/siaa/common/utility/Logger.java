/**
 * 
 */
package pe.infounsa.siaa.common.utility;

/**
 * Wrapper class for log messages
 * 
 * @author Siaa
 *
 */
public class Logger {

	private static org.apache.log4j.Logger logger = null;

	private static boolean isInitialized = false;

	private static void logger(Object object) {
		Class<?> objectClass = object.getClass();
		Logger.logger = org.apache.log4j.Logger.getLogger(objectClass);

		if (!isInitialized) {
			isInitialized = true;
		}
	}

	public static void warn(Object o, String msg) {
		Logger.logger(o);
		Logger.logger.warn(msg);
	}

	public static void error(Object o, String msg) {
		Logger.logger(o);
		Logger.logger.error(msg);
	}

	public static void error(Object o, Exception e) {
		Logger.logger(o);
		Logger.logger.error(o, e);
	}

	public static void error(Object o, Throwable t) {
		Logger.logger(o);
		Logger.logger.error(o, t);
	}

	public static void debug(Object o, String msg) {
		Logger.logger(o);
		Logger.logger.debug(msg);
	}

	public static void info(Object o, String msg) {
		Logger.logger(o);
		Logger.logger.info(msg);
	}

	protected static void reset() {
		Logger.logger = null;
		Logger.isInitialized = false;
	}
}
