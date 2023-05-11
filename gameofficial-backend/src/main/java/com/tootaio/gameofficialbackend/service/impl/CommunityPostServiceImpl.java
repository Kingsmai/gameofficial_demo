package com.tootaio.gameofficialbackend.service.impl;

import com.tootaio.gameofficialbackend.entity.CommunityPost;
import com.tootaio.gameofficialbackend.entity.UserAccount;
import com.tootaio.gameofficialbackend.mapper.CommunityPostMapper;
import com.tootaio.gameofficialbackend.mapper.HashtagMapper;
import com.tootaio.gameofficialbackend.mapper.PostHashtagMapper;
import com.tootaio.gameofficialbackend.service.CommunityPostService;
import com.tootaio.gameofficialbackend.utils.HashtagExtractor;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommunityPostServiceImpl implements CommunityPostService {
    @Resource
    CommunityPostMapper communityPostMapper;

    @Resource
    HashtagMapper hashtagMapper;

    @Resource
    PostHashtagMapper postHashtagMapper;

    @Override
    public List<CommunityPost> getAllCommunityPosts() {
        List<CommunityPost> posts = communityPostMapper.getAllPosts();
        // 关联每个 post 和它的 hashtag
        for (CommunityPost post : posts) {
            post.setTags(postHashtagMapper.getHashtagsByCommunityPostId(post.getId()));
        }
        return posts;
    }

    @Override
    public String createNewPost(UserAccount user, String content) {
        int insertResult = communityPostMapper.CreateNewPost(user.getId(), content);
        if (insertResult < 0) {
            return "发帖失败，请联系管理员";
        }

        // 获取刚刚插入的 postId
        int latestPostId = communityPostMapper.getLatestPostId();

        // 查询句子中所包含的 hashtag，
        List<String> extractedHashtags = HashtagExtractor.extract(content);

        // 查重，如果是新的 hashtag，添加到表中
        for (String hashtag : extractedHashtags) {
            int checkResult = hashtagMapper.checkHashtagExists(hashtag);
            if (checkResult == 0) {
                if (hashtagMapper.createHashtag(hashtag) < 0) {
                    return "发帖成功，但创建 hashtag 的过程中发生异常";
                }
            }
            // 获取 hashtagId
            int hashtagId = hashtagMapper.getHashtagId(hashtag);
            // 再将 postId 和 hashTagId 表添加到 hashtag_post 表中
            if (postHashtagMapper.connectCommunityPostAndHashtag(latestPostId, hashtagId) < 0) {
                return "发帖成功，但关联 hashtag 的过程中发生异常";
            }
        }
        return null;
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
