package com.elio.edu.security;

import com.elio.edu.login.dto.UserDto;
import com.elio.edu.login.service.UserService;
import com.elio.edu.util.HashUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthProvider implements AuthenticationProvider {

    private Logger logger = LoggerFactory.getLogger(AuthProvider.class);

    @Autowired
    UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) {
        String email = authentication.getName();
        String password = HashUtil.sha256(authentication.getCredentials().toString());
        logger.info("email : " + email);
        logger.info("password : " + password);
        UserDto userDto = userService.selectUser(email, password);
        //UserDto userDto = new UserDto();
        //userDto.setEmail(email);

        if (userDto == null) {
            throw new BadCredentialsException("Login Error !!");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new UsernamePasswordAuthenticationToken(userDto, null, authorities);
    }

    @Override
    public boolean supports(Class authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
