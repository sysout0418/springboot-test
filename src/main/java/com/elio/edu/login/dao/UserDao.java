package com.elio.edu.login.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Mapper
@Transactional
public interface UserDao {

    Map<String, Object> selectUser(Map<String, Object> param);

}
