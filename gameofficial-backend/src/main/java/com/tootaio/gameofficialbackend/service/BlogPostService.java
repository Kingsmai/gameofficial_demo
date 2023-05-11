package com.tootaio.gameofficialbackend.service;

import com.tootaio.gameofficialbackend.entity.BlogPost;
import com.tootaio.gameofficialbackend.entity.UserAccount;

import java.util.List;

public interface BlogPostService {
    List<BlogPost> getAllBlogPost();

    String createNewPost(UserAccount user, String title, String content);

    String updatePost(UserAccount user, long postId, String title, String content);

    String deletePostById(UserAccount user, long postId);

    BlogPost getPostById(long postId);
}
