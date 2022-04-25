package cn.chennian.apigateway.routerconfig;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * api 代码方式配置
 *
 * @author ningchang
 * @version 1.0
 * @date 2022-04-25 15:39
 */
@Component
public class CodeConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route",
                        r -> r.alwaysTrue().uri("http://www.baidu.com"))
//                .route("", r -> r.alwaysTrue().filters(f -> f.).uri(""))
                .build();
    }

}

