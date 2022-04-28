package cn.chennian.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@RefreshScope
public class CloudGatewayApplication {

    public static void main(String[] args) {

        SpringApplication.run(CloudGatewayApplication.class, args);

    }

}
