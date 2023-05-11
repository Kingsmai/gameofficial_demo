package com.tootaio.gameofficialbackend.service;

import com.tootaio.gameofficialbackend.entity.BlogPost;
import com.tootaio.gameofficialbackend.entity.UserAccount;

import java.util.List;

public interface BlogPostService {
    List<BlogPost> getAllBlogPost();

    String createNewPost(UserAccount user, String title, String content);

    String deletePostById(UserAccount user, int postId);
}
