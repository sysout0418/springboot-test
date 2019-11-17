package com.elio.edu.login.service;

import com.elio.edu.login.dao.UserDao;
import com.elio.edu.login.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {

    @Autowired
    UserDao userDao;

    public UserDto selectUser(String email, String password) {
        UserDto userDto = new UserDto();
        userDto.setEmail(email);
        userDto.setAccountPassword(password);
        userDto = userDao.selectUser(userDto);

        return userDto;
    }

}
