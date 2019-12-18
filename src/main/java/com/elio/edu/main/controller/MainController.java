package com.elio.edu.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private Logger logger = LoggerFactory.getLogger(MainController.class);

    // 메인 페이지
    @GetMapping("/")
    public String index() {
        return "/main/index";
    }

}
