package com.tootaio.gameofficialbackend.mapper;

import com.tootaio.gameofficialbackend.entity.CommunityPost;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommunityPostMapper {
    @Select("SELECT community_post.id,\n" +
            "       community_post.userId,\n" +
            "       account.username,\n" +
            "       community_post.postTime,\n" +
            "       community_post.content\n" +
            "FROM community_post\n" +
            "         JOIN account ON community_post.userId = account.id\n" +
            "ORDER BY postTime DESC")
    List<CommunityPost> getAllPosts();

    // 发帖
    @Insert("INSERT INTO community_post (userId, content) VALUE (#{userId}, #{content})")
    int CreateNewPost(int userId, String content);
}
