package com.inflearn.studyproject.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception { //특정 경로는 인증 없이 접속할 수 있도록 함
        http.authorizeRequests()
                .mvcMatchers("/", "/login", "/sign-up", "/check-email", "/check-email-token", "/email-login", "/check-email-login", "/login-link").permitAll()
                .mvcMatchers(HttpMethod.GET, "/profile/*").permitAll()
                .anyRequest().authenticated();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .mvcMatchers("/node_modules/**") //빌드시 생성되는 static 폴더 하위의 node_modules도 로그인 없이 사용할 수 있도록 설정함
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()); //resources 하위의 static 폴더의 이미지, css 등등을 포함한 자원들을 로그인 없이 가져올 수 있도록 설정함
    }
}
