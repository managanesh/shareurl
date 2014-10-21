package com.sri.shareurl.addurl.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.sri.shareurl.addurl.interceptor.Neo4jDataInterceptor;
import com.sri.shareurl.addurl.neo4j.repo.UserRepository;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
	Logger log = Logger.getLogger(getClass());

	@Autowired
	public UserRepository userRepository;
	
	@Bean
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
		RequestMappingHandlerAdapter handlerAdapter = super
				.requestMappingHandlerAdapter();
		// handlerAdapter.getMessageConverters().add(0,
		// getProtobufJsonMessageConverter());
		return handlerAdapter;
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration neo4jRegistration = registry
				.addInterceptor(new Neo4jDataInterceptor(userRepository));
		neo4jRegistration.addPathPatterns("/service/**");
		
		log.info("Neo4j interceptor");
	}

	
	
	
}
