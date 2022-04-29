package cn.chennian.cloudgateway.sentinel;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义熔断后的fallback 方法
 *
 * <p>
 *     # fallback 模式，目前有三种：response、redirect、空（我们走自定义fallback类内容）
 *
 *     # 对应 response 模式
 *           response-status: 429 # 响应状态码，默认为 429
 *           response-body: This request is blocked by erbadagang's sentinel. # 响应内容，默认为空
 *           content-type: application/json # 内容类型，默认为 application/json
 *
 *     # 对应 redirect 模式
 *           redirect: http://www.baidu.com
 *
 * </p>
 *
 * @author ningchang
 * @version 1.0
 * @date 2022-04-29 10:38
 */
@Component
public class CustomBlockRequestHandler implements BlockRequestHandler {
    @Override
    public Mono<ServerResponse> handleRequest(ServerWebExchange serverWebExchange, Throwable throwable) {
        return null;
    }
}
