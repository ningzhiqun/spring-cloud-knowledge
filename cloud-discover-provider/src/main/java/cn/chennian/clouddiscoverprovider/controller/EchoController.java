package cn.chennian.clouddiscoverprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author ningchang
 * @version 1.0
 * @date 2022-04-30 14:34
 */
@RestController
@RequestMapping("echo")
public class EchoController {

    @Value("${server.port}")
    private int port;

    @GetMapping("say")
    public String say(@RequestParam("content") String content) {
        return content + " - " + port + " - " + Math.random();
    }

}
