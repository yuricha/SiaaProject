package pe.infounsa.siaa.rest.services.seguridad.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import pe.infounsa.siaa.common.utility.Logger;
import pe.infounsa.siaa.rest.controller.message.ErrorDetail;
import pe.infounsa.siaa.rest.controller.message.ResponseError;

public class RestMessageUtil {

	public static ResponseError getResponseError(MessageSource messageSource,
			String... errorMessage) {
		List<ErrorDetail> errors = new ArrayList<ErrorDetail>();
		Locale locale = LocaleContextHolder.getLocale();

		Logger.info(RestMessageUtil.class, "Locale " + locale
				+ " will be used for error messages");

		for (String message : errorMessage) {

			errors.add(new ErrorDetail(messageSource.getMessage(message, null,
					locale)));

			errors.add(new ErrorDetail(message));
		}

		return new ResponseError(errors);
	}
}
