/**
 * 
 */
package pe.infounsa.siaa.rest.services.seguridad.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import pe.infounsa.siaa.rest.services.seguridad.evaluator.CustomMethodSecurityExpressionHandler;
import pe.infounsa.siaa.rest.services.seguridad.evaluator.CustomPermissionEvaluator;

/**
 * @author Siaa
 *
 */
@Configuration
@ComponentScan("pe.infounsa.siaa.rest.services.seguridad.evaluator")
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityMethodConfiguration extends
		GlobalMethodSecurityConfiguration {

	@Autowired
	private CustomPermissionEvaluator permissionEvaluator;

	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
		CustomMethodSecurityExpressionHandler methodSecurityExpressionHandler = new CustomMethodSecurityExpressionHandler();
		methodSecurityExpressionHandler
				.setPermissionEvaluator(permissionEvaluator);

		return methodSecurityExpressionHandler;
	}
}
