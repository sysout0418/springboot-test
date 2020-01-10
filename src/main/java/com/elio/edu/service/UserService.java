package com.elio.edu.service;

import com.elio.edu.entity.UserEntity;

public interface UserService {

    UserEntity findByMdn(String mdn);

    void joinUser(UserEntity user);

}
