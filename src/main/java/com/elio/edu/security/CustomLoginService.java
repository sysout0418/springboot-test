package com.elio.edu.security;

import com.elio.edu.entity.UserEntity;
import com.elio.edu.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomLoginService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("mdn : " +  username);
        UserEntity user = userRepository.findByMdn(username);
        if (user == null) {
            throw new UsernameNotFoundException("회원정보 없음");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        if ("01039270323".equals(username)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
        }

        return new org.springframework.security.core.userdetails.User(user.getMdn(), user.getAccountPassword(), authorities);
    }

}
