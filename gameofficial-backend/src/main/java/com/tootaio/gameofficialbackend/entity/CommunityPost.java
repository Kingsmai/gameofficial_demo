package com.tootaio.gameofficialbackend.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommunityPost {
    Long id;

    int userId;

    String username;

    Timestamp postTime;

    String content;
}
