/**
 * 
 */
package pe.infounsa.siaa.dataaccess.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Siaa
 *
 */
@Configuration
@ComponentScan(value = {"pe.infounsa.siaa.dataaccess.impl","pe.infounsa.siaa.dataaccess.custom.impl"})
public class DataAccessConfiguration {

}
