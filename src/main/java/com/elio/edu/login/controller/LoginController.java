package com.elio.edu.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/loginView")
    public String loginView() {
        return "login/loginView";
    }

    @RequestMapping("/forgotPasswordView")
    public String forgotPasswordView() {
        return "login/forgotPasswordView";
    }

    @RequestMapping("/registerView")
    public String registerView() {
        return "login/registerView";
    }

    @RequestMapping("/resetPasswordView")
    public String resetPasswordView() {
        return "login/resetPasswordView";
    }

}
