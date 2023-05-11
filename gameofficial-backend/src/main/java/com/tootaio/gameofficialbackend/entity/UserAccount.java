package com.tootaio.gameofficialbackend.entity;

import lombok.Data;

@Data
public class UserAccount {
    int id;
    String email;
    String username;
    int roleId;
}
