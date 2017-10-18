/**
 * 
 */
package pe.infounsa.siaa.rest.services.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import pe.infounsa.siaa.rest.services.json.DateDeserializer;
import pe.infounsa.siaa.rest.services.json.DateSerializer;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author Siaa
 *
 */
@Configuration
public class RestCommonConfiguration {

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
		resource.setBasenames("classpath:messages/messages",
				"classpath:messages/exceptions",
				"classpath:messages/validations", "classpath:messages/errors");
		resource.setUseCodeAsDefaultMessage(true);
		resource.setDefaultEncoding("UTF-8");
		resource.setCacheSeconds(30);

		return resource;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	    resolver.setDefaultEncoding("utf-8");
	    resolver.setMaxUploadSize(10485760);   // 10MB
	    resolver.setMaxInMemorySize(1048576);  // 1MB
	    return resolver;
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter messageConverter() {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setSerializationInclusion(Include.NON_NULL);
//		mapper.enable(SerializationFeature.INDENT_OUTPUT);
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
//				true);
//		
//		
//
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//		converter.setObjectMapper(mapper);
			
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.serializationInclusion(Include.ALWAYS);
		builder.featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		// builder.propertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE);

		builder.deserializerByType(Date.class, new DateDeserializer()).dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		builder.serializerByType(Date.class, new DateSerializer()).dateFormat(new SimpleDateFormat("dd-MM-yyyy"));
		
		//builder.deserializerByType(Datetime.class, new DatetimeDeserializer());
		//builder.serializerByType(Datetime.class, new DatetimeSerializer());
		builder.indentOutput(true).failOnUnknownProperties(false)
				.dateFormat(new SimpleDateFormat("dd-MM-yyyy"));
		
		
		return new MappingJackson2HttpMessageConverter(builder.build());
	}
}
