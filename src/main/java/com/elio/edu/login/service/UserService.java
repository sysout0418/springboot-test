package com.elio.edu.login.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface UserService {

    Map<String, Object> selectUser(String email, String password);

}
