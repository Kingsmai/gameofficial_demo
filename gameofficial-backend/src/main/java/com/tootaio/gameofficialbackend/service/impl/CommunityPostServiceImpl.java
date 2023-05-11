package com.tootaio.gameofficialbackend.service.impl;

import com.tootaio.gameofficialbackend.entity.CommunityPost;
import com.tootaio.gameofficialbackend.entity.UserAccount;
import com.tootaio.gameofficialbackend.mapper.CommunityPostMapper;
import com.tootaio.gameofficialbackend.service.CommunityPostService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityPostServiceImpl implements CommunityPostService {
    @Resource
    CommunityPostMapper communityPostMapper;

    @Override
    public List<CommunityPost> getAllCommunityPosts() {
        return communityPostMapper.getAllPosts();
    }

    @Override
    public boolean createNewPost(UserAccount user, String content) {
        return communityPostMapper.CreateNewPost(user.getId(), content) > 0;
    }

    @Override
    public String deletePostById(UserAccount user, int postId) {
        CommunityPost post = communityPostMapper.getPostById(postId);

        if (post == null) {
            return "查无此帖子";
        }

        // 如果不是管理员，也不是发帖人
        if (!user.isAdmin() && post.getUserId() != user.getId()) {
            return "你没有权限删除此帖子";
        }

        if (communityPostMapper.DeletePostById(postId) > 0) {
            return null;
        } else {
            return "内部错误，请联系管理员";
        }
    }
}
