package com.tootaio.gameofficialbackend.controller;

import com.tootaio.gameofficialbackend.entity.CommunityPost;
import com.tootaio.gameofficialbackend.entity.bean.RestBean;
import com.tootaio.gameofficialbackend.service.CommunityPostService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class CommunityPostController {
    @Resource
    CommunityPostService communityPostService;

    @GetMapping("/get")
    public RestBean<List<CommunityPost>> getAllCommunityPost() {
        return RestBean.success(communityPostService.getAllCommunityPosts());
    }
}
