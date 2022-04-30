package cn.chennian.clouddiscoverconsumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author ningchang
 * @version 1.0
 * @date 2022-04-30 14:38
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @GetMapping("demo/{content}")
    public String demo(@PathVariable("content")String content) {
        return content;
    }

}
