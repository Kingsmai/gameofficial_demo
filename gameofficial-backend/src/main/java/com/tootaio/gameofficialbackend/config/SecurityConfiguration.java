package com.tootaio.gameofficialbackend.config;

import com.alibaba.fastjson2.JSON;
import com.tootaio.gameofficialbackend.entity.RestBean;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Resource
    DataSource dataSource;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        return security
                .authorizeHttpRequests()
                .requestMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginProcessingUrl("/api/auth/login")
                .successHandler(this::onAuthenticationSuccess)
                .failureHandler(this::onAuthenticationFailure)
                .and()
                .logout().logoutUrl("/api/auth/login")
                .logoutSuccessHandler(this::onAuthenticationSuccess)
                .and()
                .csrf().disable()
                .cors().configurationSource(this.corsConfigurationSource())
                .and()
                .exceptionHandling().authenticationEntryPoint(this::onAuthenticationFailure)
                .and().build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String json = "";
        if (req.getRequestURI().contains("/login")) {
            json = JSON.toJSONString(RestBean.success("登录成功"));
        } else if (req.getRequestURI().contains("/logout")) {
            json = JSON.toJSONString(RestBean.success("登出成功"));
        }
        resp.getWriter().write(json);
    }

    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String json = JSON.toJSONString(RestBean.failure(exception.getMessage()));
        resp.getWriter().write(json);
    }

    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration cors = new CorsConfiguration();
        cors.addAllowedOriginPattern("*");
        cors.setAllowCredentials(true);
        cors.addAllowedHeader("*");
        cors.addAllowedMethod("*");
        cors.addExposedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cors);
        return source;
    }
}