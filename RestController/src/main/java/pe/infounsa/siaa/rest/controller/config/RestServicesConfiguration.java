/**
 * 
 */
package pe.infounsa.siaa.rest.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Configuration class to define package to scan with Spring framework
 * 
 * @author Siaa
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pe.infounsa.siaa.rest.controller")
public class RestServicesConfiguration extends WebMvcConfigurerAdapter {
//public class RestServicesConfiguration {

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
 
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
 
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/view/siaaClient/");
        bean.setSuffix(".jsp");
        return bean;
    }
 
   
	
}
