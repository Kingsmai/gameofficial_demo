package com.tootaio.gameofficialbackend.service;

import com.tootaio.gameofficialbackend.entity.BlogPost;
import com.tootaio.gameofficialbackend.entity.bean.RestBean;

import java.util.List;

public interface BlogPostService {
    List<BlogPost> getAllBlogPost();
}
