package com.tootaio.gameofficialbackend.service.impl;

import com.tootaio.gameofficialbackend.entity.Account;
import com.tootaio.gameofficialbackend.mapper.UserMapper;
import com.tootaio.gameofficialbackend.service.AuthorizeService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeServiceImpl implements AuthorizeService {
    @Resource
    UserMapper userMapper;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("")) {
            throw new UsernameNotFoundException("用户名不能为空");
        }

        Account account = userMapper.findAccountByUsernameOrEmail(username);
        if (account == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }

        return User
                .withUsername(account.getUsername())
                .password(account.getPassword())
                .roles(account.getRoleId() == 0 ? "admin" : "user").build();
    }

    @Override
    public String Register(String username, String password, String email) {
        if (userMapper.findAccountByEmail(email) != null) {
            return "此邮箱已被注册";
        }

        if (userMapper.findAccountByUsername(username) != null) {
            return "此用户名已被注册";
        }

        password = encoder.encode(password);
        return userMapper.createAccount(username, password, email) > 0 ? null : "内部错误，请联系管理员";
    }

    @Override
    public String resetPassword(String password, String email) {
        if (userMapper.findAccountByEmail(email) == null) {
            return "此邮箱尚未在系统中注册";
        }

        password = encoder.encode(password);
        return userMapper.resetPasswordByEmail(password, email) > 0 ? null : "内部错误，请联系管理员";
    }
}
