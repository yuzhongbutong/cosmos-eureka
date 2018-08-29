package org.athena.ribbon.client.controller;

import org.athena.ribbon.client.entities.InformationEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "athena-eureka-client", fallback = FeignHystric.class)
public interface FeignConsumer {

	@GetMapping(value = "/api/{name}")
	public InformationEntity accessInfomation(@PathVariable("name") String name,
			@RequestParam(required = false, defaultValue = "0", name = "age") String age);
}