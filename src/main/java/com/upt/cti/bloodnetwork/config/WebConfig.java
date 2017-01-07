package com.upt.cti.bloodnetwork.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.upt.cti.bloodnetwork.web.WebBeansMarker;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = { WebBeansMarker.class })
public class WebConfig extends WebMvcConfigurerAdapter {

	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
		configurer.favorPathExtension(false);
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false);
	}

	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(converter());
	}

	@Bean
	public MappingJackson2HttpMessageConverter converter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		return converter;
	}
}
