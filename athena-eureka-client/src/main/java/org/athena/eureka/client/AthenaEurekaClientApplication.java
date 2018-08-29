package org.athena.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AthenaEurekaClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(AthenaEurekaClientApplication.class, args);
	}
}
