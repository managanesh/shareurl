package com.sri.shareurl.addurl.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableAutoConfiguration
@ComponentScan("com.sri.shareurl.addurl")
@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = "com.sri.shareurl.addurl.neo4j")
public class AddURLApplication extends SpringBootServletInitializer {

	private static Log logger = LogFactory.getLog(AddURLApplication.class);

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AddURLApplication.class);
	}

	public static void main(String... args) {
		SpringApplication.run(AddURLApplication.class, args);
	}
	
	

}
