package com.tootaio.gameofficialbackend.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BlogPost {
    long id;
    long userId;
    String title;
    Timestamp postTime;
    String content;
}
