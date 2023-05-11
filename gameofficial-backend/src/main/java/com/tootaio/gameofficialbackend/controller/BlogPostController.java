package com.tootaio.gameofficialbackend.controller;

import com.tootaio.gameofficialbackend.entity.BlogPost;
import com.tootaio.gameofficialbackend.entity.bean.RestBean;
import com.tootaio.gameofficialbackend.service.BlogPostService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
