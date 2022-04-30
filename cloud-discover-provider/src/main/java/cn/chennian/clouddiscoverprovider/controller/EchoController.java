package cn.chennian.clouddiscoverprovider.controller;

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

    @GetMapping("say")
    public String say(@RequestParam("content") String content) {
        return content;
    }

}
