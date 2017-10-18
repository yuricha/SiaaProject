package pe.infounsa.siaa.rest.services.json;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateSerializer extends JsonSerializer<Date>{
	
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat(
			"dd-MM-yyyy");
	private static final DateFormat DATETIME_FORMAT = new SimpleDateFormat(
			"dd-MM-yyyy HH:mm:ss");
	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(value);
		String formattedDate;
		int hora = calendar.get(Calendar.HOUR_OF_DAY);
		int minuto = calendar.get(Calendar.MINUTE);
		int segundos = calendar.get(Calendar.SECOND);
		
		if((hora+minuto+segundos)>0)
			formattedDate = DATETIME_FORMAT.format(value);
		else
			formattedDate = DATE_FORMAT.format(value);

		gen.writeString(formattedDate);
		
	}
}
