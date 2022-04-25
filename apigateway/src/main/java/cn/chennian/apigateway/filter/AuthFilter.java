package cn.chennian.apigateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.Buffer;
import java.util.Optional;

/**
 * <p></p>
 *
 * @author ningchang
 * @version 1.0
 * @date 2022-04-25 16:16
 */
@Component
public class AuthFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 过滤不要拦截的路径
        String path = exchange.getRequest().getURI().getPath();

        // 获取token 并判断登录状态
        String token = (String) Optional.ofNullable(exchange.getAttribute("token")).orElseThrow(() -> new RuntimeException(""));
        if (StringUtils.hasText(token)) {
            ServerHttpResponse response = exchange.getResponse();
//            return response.writeAndFlushWith(Flux.just(new byte[], ""));
        }

        // 用token 去redis 查询是否登录过


        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }
}
