/**
 * 
 */
package pe.infounsa.siaa.rest.services.seguridad.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import pe.infounsa.siaa.business.seguridad.GestionarUserDetailsBusiness;
import pe.infounsa.siaa.rest.services.config.RestCommonConfiguration;
import pe.infounsa.siaa.rest.services.seguridad.expression.CustomWebSecurityExpressionHandler;
import pe.infounsa.siaa.rest.services.seguridad.filter.HeaderAuthenticationFilter;
import pe.infounsa.siaa.rest.services.seguridad.handler.HeaderAuthenticationHandler;
import pe.infounsa.siaa.rest.services.seguridad.handler.RestAuthenticationEntryPoint;
import pe.infounsa.siaa.rest.services.seguridad.handler.RestAuthenticationFailureHandler;
import pe.infounsa.siaa.rest.services.seguridad.handler.RestAuthenticationSuccessHandler;
import pe.infounsa.siaa.rest.services.seguridad.handler.RestLogoutSuccessHandler;
import pe.infounsa.siaa.rest.services.seguridad.provider.CustomAuthenticationProvider;

/**
 * @author Siaa
 *
 */
@Configuration
@Import(RestCommonConfiguration.class)
@PropertySource({"classpath:security.properties"})
@ComponentScan(value = {
		"pe.infounsa.siaa.rest.services.seguridad.handler",
		"pe.infounsa.siaa.rest.services.seguridad.expression" })
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	@Autowired
	private CustomWebSecurityExpressionHandler securityExpressionHandler;

	@Autowired
	private RestAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	private RestAuthenticationFailureHandler authenticationFailureHandler;

	@Autowired
	private RestAuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	private RestLogoutSuccessHandler logoutSuccessHandler;
	
	@Autowired
	private GestionarUserDetailsBusiness userDetailsService;
	
	@Autowired
    private HeaderAuthenticationHandler headerAuthenticationHandler;

	
	@Bean
	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
		return new StandardPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {

		AuthenticationProvider authenticationProvider = new CustomAuthenticationProvider();

		return authenticationProvider;
	}
	
	@Autowired
	public void registerGlobalAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {

		auth.authenticationProvider(authenticationProvider());

		// .userDetailsService(gestionarUserDetailsBusiness)
		// .passwordEncoder(passwordEncoder());

	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().expressionHandler(securityExpressionHandler)
				.antMatchers(HttpMethod.POST, "/cajabancos/**")
				.access("hasAccessPedidos()")
				.antMatchers(HttpMethod.POST, "/mantenimiento/**")
				.access("hasAccessCocina()").anyRequest().authenticated().and()
				.anonymous().disable();
 
		 http.csrf().disable();

		http.sessionManagement().sessionCreationPolicy(
				SessionCreationPolicy.STATELESS);

		http.exceptionHandling().authenticationEntryPoint(
				authenticationEntryPoint);

		http.formLogin().loginPage("/signin").usernameParameter("user")
				.passwordParameter("pass")
				.successHandler(authenticationSuccessHandler)
				.failureHandler(authenticationFailureHandler).permitAll();

		
		http.logout().logoutUrl("/signout").invalidateHttpSession(true)
				.logoutSuccessHandler(logoutSuccessHandler).permitAll();
		
		http.addFilterBefore(authenticationFilter(), LogoutFilter.class);

	}
	
	private Filter authenticationFilter() {
        HeaderAuthenticationFilter headerAuthenticationFilter = new HeaderAuthenticationFilter();
        headerAuthenticationFilter.userDetailsService(userDetailsService);
        headerAuthenticationFilter.authenticationHandler(headerAuthenticationHandler);
        return headerAuthenticationFilter;
    }

}
