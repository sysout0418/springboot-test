package com.elio.edu.login.controller;

import com.elio.edu.login.dto.UserDto;
import com.elio.edu.login.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    // 회원가입 페이지
    @GetMapping("/user/join")
    public String userJoin() {
        return "/login/join";
    }

    // 회원가입 처리
    @PostMapping("/user/join")
    public String goUserJoin(UserDto userDto) {
        userService.joinUser(userDto);

        return "redirect:/user/login";
    }

    // 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "/login/loginView";
    }

    // 로그인 결과 페이지
    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "redirect:/";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "redirect:/";
    }

    // 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }

    // 내 정보 페이지
    @GetMapping("/user/myInfo")
    public String dispMyInfo() {
        return "user/myinfo";
    }

    // 어드민 페이지
    @GetMapping("/admin")
    public String adminMain() {
        return "/admin/adminMain";
    }

}
