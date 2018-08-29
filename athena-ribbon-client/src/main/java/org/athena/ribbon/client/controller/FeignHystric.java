package org.athena.ribbon.client.controller;

import org.athena.ribbon.client.entities.InformationEntity;
import org.springframework.stereotype.Component;

@Component
public class FeignHystric implements FeignConsumer {

	@Override
	public InformationEntity accessInfomation(String name, String age) {
		InformationEntity informationEntity = new InformationEntity();
		informationEntity.setName(name);
		informationEntity.setAge(age);
		informationEntity.setError("[ERROR]: Thie service is not available from feign.");
		return informationEntity;
	}

}
