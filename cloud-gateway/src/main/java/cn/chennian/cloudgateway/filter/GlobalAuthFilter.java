package cn.chennian.cloudgateway.filter;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * 全局拦截器
 *
 * @author ningchang
 * @version 1.0
 * @date 2022-04-28 14:04
 */

public class GlobalAuthFilter implements GlobalFilter, Ordered {

    /**
     * 不需要拦截的路径
     */
    @Value("${gateway.noAuthPath}")
    private List<String> noAuthPath;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();

        if (noAuthPath.contains(path)) {
            return chain.filter(exchange);
        }

        String sessionId = exchange.getRequest().getHeaders().getFirst("sessionId");
        if (StringUtils.hasText(sessionId) && "校验redis 中存在登录秘钥".length() == 1) {
            // 将用户信息解析出来，绑定到请求头上
            exchange.getRequest().getHeaders().set("userBaseInfo", "");
        }
        else {
            // 返回未登录状态码
        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
