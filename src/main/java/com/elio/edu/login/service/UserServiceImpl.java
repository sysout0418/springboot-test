package com.elio.edu.login.service;

import com.elio.edu.login.dao.UserDao;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("UserService")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public Map<String, Object> selectUser(String email, String password) {
        Map<String, Object> param = new HashMap<>();
        param.put("EMAIL", email);
        param.put("ACCOUNT_PASSWORD", password);
        Map<String, Object> userInfo = userDao.selectUser(param);
        return userInfo;
    }

}
