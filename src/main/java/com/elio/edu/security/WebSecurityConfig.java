package com.elio.edu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthProvider authProvider;

    @Autowired
    AuthFailureHandler authFailureHandler;

    @Autowired
    AuthSuccessHandler authSuccessHandler;

    @Override
    public void configure(WebSecurity web) {
        // 허용되어야 할 경로들
        web.ignoring().antMatchers("/resources/**",
                "/login/");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 로그인 설정
        http.authorizeRequests()
                .antMatchers("/user/loginView", "/error**").permitAll()
                .antMatchers("/**").access("ROLE_USER")
                .antMatchers("/**").access("ROLE_ADMIN")
                .antMatchers("/admin/**").access("ROLE_ADMIN")
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/user/loginView")
                .defaultSuccessUrl("/main/index")
                //.failureHandler(authFailureHandler)
                //.successHandler(authSuccessHandler)
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .and()
                .csrf()
                .disable()
                .authenticationProvider(authProvider);
    }

}
