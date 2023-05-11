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
}
