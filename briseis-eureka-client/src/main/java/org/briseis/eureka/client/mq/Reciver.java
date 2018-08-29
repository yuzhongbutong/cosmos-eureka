package org.briseis.eureka.client.mq;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "exchange.briseis")
public class Reciver {

	@RabbitHandler
	public Map<String, Object> process(Map<String, Object> params) {
		params.put("stature", "216cm");
		return params;
	}
}
