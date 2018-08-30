package org.briseis.eureka.client;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class BriseisEurekaClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(BriseisEurekaClientApplication.class, args);
	}

	@Bean
	public Queue getQueue() {
		return new Queue("exchange.briseis");
	}
}
