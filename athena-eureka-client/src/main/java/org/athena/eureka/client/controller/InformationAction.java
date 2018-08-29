package org.athena.eureka.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.athena.eureka.client.mq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InformationAction {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private Sender sender;

	@Value("${spring.application.name}")
	private String appName;

	@Value("${server.port}")
	private String serverPort;

	@Value("${app.config.url}")
	private String url;

	@RequestMapping(value = "api/{name}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> getInfomation(@PathVariable("name") String name,
			@RequestParam(required = false, defaultValue = "0", name = "age") String age,
			HttpServletResponse response) {
		Map<String, String> result = new HashMap<String, String>();
		result.put("appName", appName);
		result.put("serverPort", serverPort);
		List<ServiceInstance> instanceList = discoveryClient.getInstances(appName);
		result.put("instanceLength", String.valueOf(instanceList.size()));
		result.put("services", discoveryClient.getServices().toString());
		result.put("name", name);
		result.put("age", age);
		result.put("url", url);
		Map<String, Object> mqResult = sender.send(new HashMap<String, Object>());
		String stature = mqResult.get("stature").toString();
		result.put("stature", stature);
		response.setHeader("Content-Type", "application/json; charset=utf-8");
		return result;
	}
}