package com.yc.cloud.zuul.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class LoginFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		//
		HttpServletRequest request = ctx.getRequest();
		//
		Object accessToken = request.getParameter("accessToken");
		if(accessToken == null) {
			System.err.println("access token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			ctx.setResponseBody("{\"result\":\"accessToken is empty!\"}");
			return null;
		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}
