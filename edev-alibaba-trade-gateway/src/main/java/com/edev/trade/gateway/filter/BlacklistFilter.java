/*
 * Created by 2021-03-26 18:40:57 
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

import java.net.InetSocketAddress;

/**
 * The filter that refuse the host's ip which is in the blacklist.
 * @author fangang
 */
@Component
public class BlacklistFilter implements GlobalFilter, Ordered {
	private static final Log log = LogFactory.getLog(BlacklistFilter.class);
	@Override
	public int getOrder() {
		return 1;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		InetSocketAddress remoteAddress = request.getRemoteAddress();
		if(remoteAddress==null) return forbidden(exchange);
		String hostName = remoteAddress.getHostName();
		log.info("[ ip: "+hostName+" ]");
		if(isInBlacklist(hostName)) return forbidden(exchange);
		return chain.filter(exchange);
	}

	private Mono<Void> forbidden(ServerWebExchange exchange) {
		ServerHttpResponse response = exchange.getResponse();
		response.setStatusCode(HttpStatus.FORBIDDEN);
		return response.setComplete();
	}

	private boolean isInBlacklist(String hostName) {
		//you can read blacklist from database;
		return "192.168.0.100".equals(hostName);
	}
}
