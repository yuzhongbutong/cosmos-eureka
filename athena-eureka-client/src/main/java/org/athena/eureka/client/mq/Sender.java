package org.athena.eureka.client.mq;

import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> send(Map<String, Object> params) {
		Map<String, Object> result =  (Map<String, Object>) amqpTemplate.convertSendAndReceive("exchange.briseis", params);
		return result;
	}
}
