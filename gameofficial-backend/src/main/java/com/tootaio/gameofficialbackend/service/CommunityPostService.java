package com.tootaio.gameofficialbackend.service;

import com.tootaio.gameofficialbackend.entity.CommunityPost;
import com.tootaio.gameofficialbackend.entity.UserAccount;

import java.util.List;

public interface CommunityPostService {
    List<CommunityPost> getAllCommunityPosts();

    List<CommunityPost> getPostByPage(int pageSize, int pageNumber);

    int getTotalRecord();

    String createNewPost(UserAccount user, String content);

    String deletePostById(UserAccount user, int postId);
}
