package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	DiscoveryClientRouteDefinitionLocator dynamicRoutes(
			ReactiveDiscoveryClient rdc,
			DiscoveryLocatorProperties dlp) {
		System.out.println(rdc);
		System.out.println(dlp);
		return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	}

}
