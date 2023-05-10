package com.tootaio.gameofficialbackend.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthorizeService extends UserDetailsService {
    // 注册用户
    String Register(String username, String password, String email);

    // 重置密码
    String resetPassword(String password, String email);
}
