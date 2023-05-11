package com.tootaio.gameofficialbackend.controller;

import com.tootaio.gameofficialbackend.entity.CommunityPost;
import com.tootaio.gameofficialbackend.entity.UserAccount;
import com.tootaio.gameofficialbackend.entity.bean.RestBean;
import com.tootaio.gameofficialbackend.service.CommunityPostService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/community")
public class CommunityPostController {
    @Resource
    CommunityPostService communityPostService;

    @GetMapping("/get")
    public RestBean<List<CommunityPost>> getAllCommunityPost() {
        return RestBean.success(communityPostService.getAllCommunityPosts());
    }

    @PostMapping("/post")
    public RestBean<String> createNewPost(@SessionAttribute("account") UserAccount account,
                                          @RequestParam("content") String content) {
        String errorMessage = communityPostService.createNewPost(account, content);
        if (errorMessage == null) {
            return RestBean.success("发帖成功");
        } else {
            return RestBean.failure(errorMessage);
        }
    }

    @PostMapping("/delete")
    public RestBean<String> deletePostById(@SessionAttribute("account") UserAccount account,
                                           @RequestParam("postId") int postId) {
        String errorMessage = communityPostService.deletePostById(account, postId);
        if (errorMessage == null) {
            return RestBean.success("删帖成功");
        } else {
            return RestBean.failure(errorMessage);
        }
    }
}
