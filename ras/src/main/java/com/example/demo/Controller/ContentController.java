package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/req/login")
    public String login() {
        return "login";
    }
}