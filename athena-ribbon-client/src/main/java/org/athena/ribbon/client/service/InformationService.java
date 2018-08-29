package org.athena.ribbon.client.service;

import org.athena.ribbon.client.entities.InformationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class InformationService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallInformationService")
	public InformationEntity getService(String name, String age) {
		InformationEntity informationEntity = restTemplate
				.getForObject("http://athena-eureka-client/api/" + name + "?age=" + age, InformationEntity.class);
		informationEntity.setFrom("RESTFUL");
		return informationEntity;
	}

	public InformationEntity fallInformationService(String name, String age) {
		InformationEntity informationEntity = new InformationEntity();
		informationEntity.setName(name);
		informationEntity.setAge(age);
		informationEntity.setError("[ERROR]: Thie service is not available from restful.");
		return informationEntity;
	}
}