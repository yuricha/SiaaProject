/**
 * 
 */
package pe.infounsa.siaa.business.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Siaa
 *
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = { "pe.infounsa.siaa.business.impl",
		"pe.infounsa.siaa.business.aspect" })
public class BusinessConfiguration {

}
