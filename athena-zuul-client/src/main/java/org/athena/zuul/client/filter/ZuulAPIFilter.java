package org.athena.zuul.client.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulAPIFilter extends ZuulFilter {

	private static Logger LOGGER = LoggerFactory.getLogger(ZuulAPIFilter.class);

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		LOGGER.info("{} >>> {}", request.getMethod(), request.getRequestURL().toString());
		String token = request.getParameter("token");
		if (StringUtils.isEmpty(token)) {
			LOGGER.warn("Token is empty!");
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
			try {
				context.getResponse().getWriter()
						.write("<div style='marign: auto'><h1>401</h1><br>Access token is empty!!!</div>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			LOGGER.info("Access OK!");
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
