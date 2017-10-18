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
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
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
public class RestAuthenticationAccessDeniedHandler implements
		AccessDeniedHandler {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private MappingJackson2HttpMessageConverter messageConverter;

	private ObjectMapper mapper;

	@Override
	public void handle(HttpServletRequest request,
			HttpServletResponse response, AccessDeniedException accessException)
			throws IOException, ServletException {
		// response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
		// "Unauthorized");

		Logger.info(this,
				"==================== ACCESS DENIED ====================");
		
		Logger.error(this, accessException);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		ResponseMessage<ResponseError> responseObject = new ResponseMessage<ResponseError>();

		responseObject.setBody(RestMessageUtil.getResponseError(messageSource,
				"error.accessdenied.system"));

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
