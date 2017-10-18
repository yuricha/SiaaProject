/**
 * 
 */
package pe.infounsa.siaa.rest.services.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.core.Conventions;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import pe.infounsa.siaa.business.config.BusinessConfiguration;
import pe.infounsa.siaa.common.config.CommonBeanConfiguration;
import pe.infounsa.siaa.dataaccess.config.CacheConfiguration;
import pe.infounsa.siaa.dataaccess.config.DataAccessConfiguration;
import pe.infounsa.siaa.repository.config.RepositoryConfiguration;
import pe.infounsa.siaa.rest.services.seguridad.cors.SimpleCORSFilter;

/**
 * Initialize web application context considering custom configuration class
 * 
 * @author Siaa
 *
 */
public class RestServicesInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext context) throws ServletException {
		// Create root application context
		AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
		rootCtx.register(  
				//SecurityConfiguration.class,  
//				SecurityMethodConfiguration.class,		
				CommonBeanConfiguration.class, BusinessConfiguration.class,
				DataAccessConfiguration.class, RepositoryConfiguration.class,
				CacheConfiguration.class);

		// Manage the lifecycle of the root application context
		context.addListener(new ContextLoaderListener(rootCtx));

//		context.addFilter("securityFilter",					
//				new DelegatingFilterProxy("springSecurityFilterChain"))
//				.addMappingForUrlPatterns(null, false, "/*");
		
		
		// Create the dispatcher servlet's Spring application context
		AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
		dispatcherServlet.register(RestServicesConfiguration.class);

		ServletRegistration.Dynamic servlet = context.addServlet("dispatcher",
				new DispatcherServlet(dispatcherServlet));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");

		registerServletFilter(context, new SimpleCORSFilter());

	}
	
	protected FilterRegistration.Dynamic registerServletFilter(ServletContext servletContext, Filter filter) {
	    String filterName = Conventions.getVariableName(filter);
	    FilterRegistration.Dynamic registration = servletContext.addFilter(filterName, filter);
	    registration.setAsyncSupported(true);
	    registration.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), false, "/*");
	    return registration;
	  }

}
