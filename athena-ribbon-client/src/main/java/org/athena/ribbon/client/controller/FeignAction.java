package org.athena.ribbon.client.controller;

import javax.servlet.http.HttpServletResponse;

import org.athena.ribbon.client.entities.InformationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignAction {

	@Autowired
	private FeignConsumer feignConsumer;

	@GetMapping(value = "/feign/{name}")
	@ResponseBody
	public InformationEntity getInfomation(@PathVariable("name") String name,
			@RequestParam(required = false, defaultValue = "0", name = "age") String age,
			HttpServletResponse response) {
		response.setHeader("Content-Type", "application/json; charset=utf-8");
		InformationEntity informationEntity = feignConsumer.accessInfomation(name, age);
		informationEntity.setFrom("FEIGN");
		return informationEntity;
	}

}
