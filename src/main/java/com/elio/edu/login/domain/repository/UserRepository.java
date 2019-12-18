package com.elio.edu.login.domain.repository;

import com.elio.edu.login.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByMdn(String mdn);

}
