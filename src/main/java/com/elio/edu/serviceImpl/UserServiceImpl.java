package com.elio.edu.serviceImpl;

import com.elio.edu.entity.UserEntity;
import com.elio.edu.repository.UserRepository;
import com.elio.edu.security.Role;
import com.elio.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity findByMdn(String mdn) {
        return userRepository.findByMdn(mdn);
    }

    @Transactional
    public void joinUser(UserEntity user) {

        user.setDialCode("KR");
        user.setProfileImageUrl(null);
        user.setCustomerType("01");
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setAccountPassword(passwordEncoder.encode(user.getAccountPassword()));
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.findByMdn(username);
        if (user == null) {
            throw new UsernameNotFoundException("회원정보 없음");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        if ("01039270323".equals(username)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new org.springframework.security.core.userdetails.User(user.getMdn(), user.getAccountPassword(), authorities);
    }

}
