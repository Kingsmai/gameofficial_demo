package com.tootaio.gameofficialbackend.config;

import com.tootaio.gameofficialbackend.interceptor.AuthorizeInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    final List<String> PATH_TO_EXCLUDE = List.of(
            "/api/auth/**",
            "/api/post/**"
    );

    @Resource
    AuthorizeInterceptor authorizeInterceptor;

    // 设置拦截器，把所有路径除了 api/auth 全部拦截
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(authorizeInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(PATH_TO_EXCLUDE);
    }
}
