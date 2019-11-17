package com.elio.edu.login.dao;

import com.elio.edu.login.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {

    UserDto selectUser(UserDto userDto);

}
