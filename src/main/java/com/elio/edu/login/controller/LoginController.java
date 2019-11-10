package com.elio.edu.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user", method = RequestMethod.POST)
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

}
