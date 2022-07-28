package com.intrawey.prueba.apirest.config;

import com.intrawey.prueba.apirest.converters.MultiploConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Clase para el llamado de los converters.
 * 
 * @author Augusto
 */
@Configuration
public class ConverterConfig {

	@Bean
	public MultiploConverter getMultiploConverter() {
		return new MultiploConverter();
	}
	
}
