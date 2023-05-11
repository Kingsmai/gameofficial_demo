package com.tootaio.gameofficialbackend.service.impl;

import com.tootaio.gameofficialbackend.entity.BlogPost;
import com.tootaio.gameofficialbackend.entity.bean.RestBean;
import com.tootaio.gameofficialbackend.mapper.BlogPostMapper;
import com.tootaio.gameofficialbackend.service.BlogPostService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostServiceImpl implements BlogPostService {
    @Resource
    BlogPostMapper blogPostMapper;

    @Override
    public List<BlogPost> getAllBlogPost() {
        return blogPostMapper.getAllPost();
    }
}
