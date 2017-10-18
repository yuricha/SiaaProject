/**
 * 
 */
package pe.infounsa.siaa.rest.services.json;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import pe.infounsa.siaa.common.type.Datetime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author Siaa
 *
 */
public class DatetimeSerializer extends JsonSerializer<Datetime> {

	private static final DateFormat DATE_TIME_FORMAT = new SimpleDateFormat(
			"dd-MM-yyyy HH:mm:ss");

	@Override
	public void serialize(Datetime value, JsonGenerator gen,
			SerializerProvider serializers) throws IOException,
			JsonProcessingException {
		String formattedDate = DATE_TIME_FORMAT.format(value);

		gen.writeString(formattedDate);
	}

}
