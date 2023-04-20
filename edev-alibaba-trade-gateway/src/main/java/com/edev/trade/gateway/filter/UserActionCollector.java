package com.edev.trade.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
@Slf4j
public class UserActionCollector implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String user = "user";
        String token = request.getHeaders().getFirst("token");
        String ip = (request.getRemoteAddress()==null)?"":request.getRemoteAddress().getHostName();
        HttpMethod method = request.getMethod();
        URI uri = request.getURI();
        log.info("{},{},{},{},{}", user, token, ip, method, uri);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
