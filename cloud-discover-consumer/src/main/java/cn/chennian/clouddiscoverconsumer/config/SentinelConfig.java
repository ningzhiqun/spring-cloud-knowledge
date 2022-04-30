package cn.chennian.clouddiscoverconsumer.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p></p>
 *
 * @author ningchang
 * @version 1.0
 * @date 2022-04-30 16:33
 */
@Component
public class SentinelConfig implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
//        BlockException 实现类 1、降级异常 2、流控异常
        httpServletResponse.setStatus(499);
    }
}
