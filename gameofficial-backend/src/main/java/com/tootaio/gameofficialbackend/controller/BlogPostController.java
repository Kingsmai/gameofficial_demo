package com.tootaio.gameofficialbackend.controller;

import com.alibaba.fastjson2.JSON;
import com.tootaio.gameofficialbackend.entity.BlogPost;
import com.tootaio.gameofficialbackend.entity.UserAccount;
import com.tootaio.gameofficialbackend.entity.bean.RestBean;
import com.tootaio.gameofficialbackend.service.BlogPostService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogPostController {
    @Resource
    BlogPostService blogPostService;

    @GetMapping("/get")
    public RestBean<List<BlogPost>> getAllBlogs() {
        return RestBean.success(blogPostService.getAllBlogPost());
    }

    @PostMapping("/get")
    public RestBean<BlogPost> getBlogById(@RequestParam("blogId") long blogId) {
        BlogPost blogPost = blogPostService.getPostById(blogId);
        if (blogPost != null) {
            return RestBean.success(blogPost);
        } else {
            return RestBean.failure();
        }
    }

    @PostMapping("/post")
    public RestBean<String> createNewPost(@SessionAttribute("account") UserAccount account,
                                          @RequestParam("title") String title,
                                          @RequestParam("content") String content) {
        String errorMessage = blogPostService.createNewPost(account, title, content);
        if (errorMessage == null) {
            return RestBean.success("发布成功");
        } else {
            return RestBean.failure(errorMessage);
        }
    }

    @PostMapping("/update")
    public RestBean<String> updatePost(@SessionAttribute("account") UserAccount account,
                                       @RequestParam("blogId") long blogId,
                                       @RequestParam("title") String title,
                                       @RequestParam("content") String content) {
        String errorMessage = blogPostService.updatePost(account, blogId, title, content);
        if (errorMessage == null) {
            return RestBean.success("发布成功");
        } else {
            return RestBean.failure(errorMessage);
        }
    }

    @PostMapping("/delete")
    public RestBean<String> deletePostById(@SessionAttribute("account") UserAccount account,
                                           @RequestParam("postId") int postId) {
        String errorMessage = blogPostService.deletePostById(account, postId);
        if (errorMessage == null) {
            return RestBean.success("删除成功");
        } else {
            return RestBean.failure(errorMessage);
        }
    }
}
