package com.ideajava;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by ideajava on 4/11/17.
 */
@Controller
public class WelcomeController {

    // 通过application.properties注入
    @Value("${welcome.message:test}")
    private String message = "Hello world!";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "welcome";
    }

}
