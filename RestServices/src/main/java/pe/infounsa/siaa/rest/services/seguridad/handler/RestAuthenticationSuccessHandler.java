/**
 * 
 */
package pe.infounsa.siaa.rest.services.seguridad.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import pe.infounsa.siaa.business.seguridad.dto.UsuarioAdminDto;
import pe.infounsa.siaa.common.utility.Logger;
import pe.infounsa.siaa.rest.controller.message.ResponseMessage;
import pe.infounsa.siaa.rest.controller.seguridad.message.LoginResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Siaa
 *
 */
@Component
public class RestAuthenticationSuccessHandler extends
		SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private MappingJackson2HttpMessageConverter messageConverter;

	private ObjectMapper mapper;

	@Autowired
	private HeaderAuthenticationHandler headerAuthenticationHandler;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		clearAuthenticationAttributes(request);
		Logger.info(this, "==================== SUCCESS ====================");

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(HttpServletResponse.SC_OK);

		LoginResponse loginResponse = new LoginResponse();

		String username = ((UsuarioAdminDto) authentication.getPrincipal())  //UsuarioAdminDto
				.getUsername();

		headerAuthenticationHandler.addHeader(response, username);
		// response.setHeader(arg0, token);
		// dark
		UsuarioAdminDto user =(UsuarioAdminDto) authentication.getPrincipal();
		user.setContrasena("");
		
		
		loginResponse.setUsername((UsuarioAdminDto) authentication.getPrincipal());
		loginResponse.setStatus("OK");
		loginResponse.setLastLogin(new Date());

		ResponseMessage<LoginResponse> responseMessage = new ResponseMessage<LoginResponse>();
		responseMessage.setBody(loginResponse);

		PrintWriter writer = response.getWriter();

		mapper.writeValue(writer, responseMessage);

		writer.flush();
		writer.close();

		clearAuthenticationAttributes(request);
	}

	@PostConstruct
	private void initialize() {
		mapper = messageConverter.getObjectMapper();
	}

}
