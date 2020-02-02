package com.elio.edu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class MainController {

    //private Logger logger = LoggerFactory.getLogger(MainController.class);

    // 메인 페이지
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/error")
    public String error() {
        return "error/404";
    }

}
