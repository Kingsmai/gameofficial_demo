package com.tootaio.gameofficialbackend.entity.auth;

import lombok.Data;

@Data
public class Account {
    int id;
    String email;
    String username;
    String password;
    int roleId;
}
