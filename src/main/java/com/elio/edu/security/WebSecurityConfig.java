package com.elio.edu.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Autowired
    AuthFailureHandler authFailureHandler;*/

    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomLoginService getCustomerLoginService() {
        return new CustomLoginService();
    }

    @Override
    public void configure(WebSecurity web) {
        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
        web.ignoring().antMatchers("/webjars/**",
                "/css/**",
                "/scss/**",
                "/img/**",
                "/js/**",
                "/vendors/**",
                "/html/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // csrf disabled
        http.csrf().disable();

        http.authorizeRequests()
                // 페이지 권한 설정
                .antMatchers("/join").permitAll()
                .antMatchers("/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/file/**").hasRole("ADMIN")
                .antMatchers("/file/detail").hasRole("USER")
            .and()
                // 로그인 설정
                .formLogin()
                .loginPage("/login")
                .successHandler(loginSuccessHandler)
                //.defaultSuccessUrl("/")
                .permitAll()
            .and()
                // 로그아웃 설정
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
            .and()
                // 403 예외처리 핸들링
                .exceptionHandling().accessDeniedPage("/user/denied");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(getCustomerLoginService()).passwordEncoder(passwordEncoder());
    }

}
