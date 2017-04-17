package com.ideajava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by rason on 4/12/17.
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "ajax";
    }

}
