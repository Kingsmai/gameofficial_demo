package com.tootaio.gameofficialbackend.controller;

import com.tootaio.gameofficialbackend.entity.RestBean;
import com.tootaio.gameofficialbackend.service.AuthorizeService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/auth")
public class AuthorizeController {
    private final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private final String USERNAME_REGEX = "^[\\u4e00-\\u9fa5a-zA-Z0-9]+$";

    @Resource
    AuthorizeService service;

    @PostMapping("/register")
    public RestBean<String> registerUser(@Pattern(regexp = USERNAME_REGEX) @Length(min = 2, max = 8) @RequestParam("username") String username,
                                         @Length(min = 8, max = 16) @RequestParam("password") String password,
                                         @Pattern(regexp = EMAIL_REGEX) @RequestParam("email") String email) {
        String errorMessage = service.Register(username, password, email);
        if (errorMessage == null) {
            return RestBean.success("注册成功");
        } else {
            return RestBean.failure(errorMessage);
        }
    }

    @PostMapping("/resetPassword")
    public RestBean<String> resetPassword(@Length(min = 8, max = 16) @RequestParam("password") String password,
                                          @Pattern(regexp = EMAIL_REGEX) @RequestParam("email") String email) {
        String errorMessage = service.resetPassword(password, email);
        if (errorMessage == null) {
            return RestBean.success("密码重置成功");
        } else {
            return RestBean.failure(errorMessage);
        }
    }
}
