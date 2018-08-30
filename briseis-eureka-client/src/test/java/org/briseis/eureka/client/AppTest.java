package org.briseis.eureka.client;

import java.util.HashMap;
import java.util.Map;

import org.briseis.eureka.client.mq.TestSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BriseisEurekaClientApplication.class)
public class AppTest {

	@Autowired
	private TestSender sender;
	
	@Test
	public void testSend() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("test", "1-001");
		sender.send(params);
	}
}
