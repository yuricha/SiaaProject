package pe.infounsa.siaa.rest.services.json;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import pe.infounsa.siaa.common.utility.Logger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;

public class DateDeserializer extends JsonDeserializer<Date> {

	private static final DateFormat DATE_FORMAT_IN = new SimpleDateFormat("dd-MM-yyyy");
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		ObjectCodec oc = p.getCodec();
		TextNode node = (TextNode) oc.readTree(p);
		String dateString = node.textValue();
		
		Date result = null;
		try {
			Date dateInput = DATE_FORMAT_IN.parse(dateString);
			dateString=  DATE_FORMAT.format(dateInput);
			result = (Date)DATE_FORMAT.parse(dateString);
		} catch (ParseException e) {
			Logger.error(this, e);
		}

		return result;
	}

}
