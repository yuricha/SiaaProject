/**
 * 
 */
package pe.infounsa.siaa.rest.services.seguridad.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import pe.infounsa.siaa.common.utility.Logger;
import pe.infounsa.siaa.rest.controller.message.ResponseError;
import pe.infounsa.siaa.rest.controller.message.ResponseMessage;
import pe.infounsa.siaa.rest.services.seguridad.util.RestMessageUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Siaa
 *
 */
@Component
public class RestAuthenticationFailureHandler extends
		SimpleUrlAuthenticationFailureHandler {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private MappingJackson2HttpMessageConverter messageConverter;

	private ObjectMapper mapper;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {

		Logger.info(this, "==================== AUTH FAILURE ====================");

		Logger.error(this, exception);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		ResponseMessage<ResponseError> responseObject = new ResponseMessage<ResponseError>();

		responseObject.setBody(RestMessageUtil.getResponseError(messageSource,
				"error.authentication.system"));

		PrintWriter writer = response.getWriter();

		mapper.writeValue(writer, responseObject);
		writer.flush();
		writer.close();
	}

	@PostConstruct
	private void initialize() {
		mapper = messageConverter.getObjectMapper();
	}

}