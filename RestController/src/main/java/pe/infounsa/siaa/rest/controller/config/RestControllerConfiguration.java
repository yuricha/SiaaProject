/**
 * 
 */
package pe.infounsa.siaa.rest.controller.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class to define package to scan with Spring framework
 * 
 * @author Siaa
 *
 */
@Configuration
@ComponentScan(basePackages = "pe.infounsa.siaa.rest.controller")
public class RestControllerConfiguration {

}
