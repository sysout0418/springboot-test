package com.elio.edu.serviceImpl;

import com.elio.edu.entity.UserEntity;
import com.elio.edu.repository.UserRepository;
import com.elio.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void joinUser(Map<String, Object> param) {
        UserEntity user = new UserEntity();
        user.setMdn((String) param.get("mdn"));
        user.setEmail((String) param.get("email"));
        user.setProfileName((String) param.get("profileName"));
        user.setDialCode("KR");
        user.setProfileImageUrl(null);
        user.setCustomerType("01");
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setAccountPassword(passwordEncoder.encode((String) param.get("accountPassword")));
        user.setPasswordFailCount(0);
        user.setLanguageCode("ko");
        user.setLastRequestDate(LocalDateTime.now());
        user.setLastJoinDate(LocalDateTime.now());
        user.setLastPaymentDate(null);
        user.setLastCloseDate(null);
        user.setCustomerStatus("00");
        user.setCloseType("");
        user.setCloseDesc("");
        user.setBlockYn("N");
        user.setDeleteYn("N");
        user.setInsertedId("system");
        user.setInsertedDate(LocalDateTime.now());
        user.setUpdatedId("system");
        user.setUpdatedDate(LocalDateTime.now());
        user.setUpdatedDesc("");

        userRepository.save(user);
    }


}
