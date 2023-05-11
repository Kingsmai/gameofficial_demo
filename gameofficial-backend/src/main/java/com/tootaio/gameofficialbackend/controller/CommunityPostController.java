package com.tootaio.gameofficialbackend.controller;

import com.tootaio.gameofficialbackend.entity.CommunityPost;
import com.tootaio.gameofficialbackend.entity.UserAccount;
import com.tootaio.gameofficialbackend.entity.bean.RestBean;
import com.tootaio.gameofficialbackend.service.CommunityPostService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/newPost")
    public RestBean<String> createNewPost(@SessionAttribute("account") UserAccount account,
                                          @RequestParam("content") String content) {
        if (communityPostService.createNewPost(account, content)) {
            return RestBean.success("发帖成功");
        } else {
            return RestBean.failure("发帖失败，请联系管理员");
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
