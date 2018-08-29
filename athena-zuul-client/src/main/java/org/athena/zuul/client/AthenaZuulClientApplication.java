package org.athena.zuul.client;

import org.athena.zuul.client.filter.ZuulAPIFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class AthenaZuulClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(AthenaZuulClientApplication.class, args);
	}
	
	@Bean
	public ZuulAPIFilter getZuulAPIFilter() {
		return new ZuulAPIFilter();
	}
}
