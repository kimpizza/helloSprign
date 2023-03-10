package com.cos.security01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder encodePwd(){
        return new BCryptPasswordEncoder();
    } //해당메소드의 리턴되는 오브젝트를 ioc로 등록해준다

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/user/**").authenticated()
                .antMatchers("/manager/**").access("hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/login") // /login이라는 주소가 호출이 되면 시큐리티가 낚아채서 대신 로그인을 진행해준다. 그래서 Controller에 /login을 안만들어도 된다.
                .defaultSuccessUrl("/");

        return http.build();
    }
}