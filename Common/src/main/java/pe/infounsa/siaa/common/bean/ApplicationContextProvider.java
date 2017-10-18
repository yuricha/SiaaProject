/**
 * 
 */
package pe.infounsa.siaa.common.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * @author Siaa
 *
 */
@Component
public class ApplicationContextProvider implements ApplicationContextAware {
	private static ApplicationContext APPLICATION_CONTEXT = null;

	public static ApplicationContext getApplicationContext() {
		return APPLICATION_CONTEXT;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) {
		APPLICATION_CONTEXT = context;
	}
}
