package cn.chennian.clouddiscoverconsumer.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p></p>
 *
 * @author ningchang
 * @version 1.0
 * @date 2022-04-30 14:47
 */
@FeignClient(value = "cloud-discover-provider", path = "echo")
public interface EchoFeignService {

    @GetMapping(value = "say")
    String echo(@RequestParam("content") String content);

}
