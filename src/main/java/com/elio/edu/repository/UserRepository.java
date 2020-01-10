package com.elio.edu.repository;

import com.elio.edu.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByMdn(String mdn);

}
