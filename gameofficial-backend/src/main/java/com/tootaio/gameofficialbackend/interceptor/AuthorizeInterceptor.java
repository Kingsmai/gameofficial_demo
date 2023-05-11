package com.tootaio.gameofficialbackend.interceptor;

import com.tootaio.gameofficialbackend.entity.UserAccount;
import com.tootaio.gameofficialbackend.mapper.UserMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthorizeInterceptor implements HandlerInterceptor {
    @Resource
    UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        User user = (User) authentication.getPrincipal();
        String username = user.getUsername();
        UserAccount userAccount = userMapper.findUserAccountByUsernameOrEmail(username);
        request.getSession().setAttribute("account", userAccount);
        return true;
    }
}
