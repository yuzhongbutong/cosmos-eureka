package org.athena.turbine.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class AthenaTurbineServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(AthenaTurbineServerApplication.class, args);
	}
}
