/*
 * Created by 2021-03-26 18:49:51 
 */
package com.edev.trade.gateway.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * The filter that get the user's method and url
 * @author fangang
 */
@Component
public class UrlFilter implements GlobalFilter, Ordered {
	private static final Log log = LogFactory.getLog(UrlFilter.class);
	private static final String FORBIDDEN_URL = "/foo";
	@Override
	public int getOrder() {
		return 1;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		log.info(
	                String.format("send %s[method] request to %s[url]",
	                		request.getMethod(),
	                		request.getURI()));
		if(isForbiddenUrl(request.getURI())) return forbidden(exchange);
		return chain.filter(exchange);
	}

	private Mono<Void> forbidden(ServerWebExchange exchange) {
		ServerHttpResponse response = exchange.getResponse();
		response.setStatusCode(HttpStatus.FORBIDDEN);
		return response.setComplete();
	}

	private boolean isForbiddenUrl(URI url) {
		return FORBIDDEN_URL.equals(url.toString());
	}
}
