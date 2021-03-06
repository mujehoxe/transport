package com.config;

import com.trip.Trip;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class ExposeDocumentsIdRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(
			RepositoryRestConfiguration config,
			CorsRegistry cors) {
		config.exposeIdsFor(Trip.class);
	}

}
