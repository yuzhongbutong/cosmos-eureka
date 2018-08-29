package com.athena.eureka.client;

import java.util.HashMap;
import java.util.Map;

import org.athena.eureka.client.AthenaEurekaClientApplication;
import org.athena.eureka.client.mq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AthenaEurekaClientApplication.class)
public class MQTest {

	@Autowired
	private Sender sender;
	
	@Test
	public void testSend() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("test", "1-001");
		Map<String, Object> result = sender.send(params);
		System.out.println("/////////////////////////" + result.get("stature").toString());
	}
}
