package com.elio.edu.controller;

import com.elio.edu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    // 회원가입 페이지
    @GetMapping("/join")
    public String userJoin() {
        return "join";
    }

    // 회원가입 처리
    @PostMapping("/join")
    @ResponseBody
    public Map<String, Object> goUserJoin(@RequestBody Map<String, Object> param) {
        log.info("param > " + param);
        Map<String, Object> result = new HashMap<>();

        userService.joinUser(param);

        result.put("result_code", "0");

        return result;
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 접근 거부 페이지
    @GetMapping("/denied")
    public String dispDenied() {
        return "denied";
    }

    // 내 정보 페이지
    @GetMapping("/user/myInfo")
    public String dispMyInfo() {
        return "user/myinfo";
    }

}
