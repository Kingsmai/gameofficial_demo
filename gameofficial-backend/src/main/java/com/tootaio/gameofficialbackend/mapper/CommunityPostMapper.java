package com.tootaio.gameofficialbackend.mapper;

import com.tootaio.gameofficialbackend.entity.CommunityPost;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommunityPostMapper {
    @Select("""
            SELECT community_post.id,
                   community_post.userId,
                   account.username,
                   community_post.postTime,
                   community_post.content
            FROM community_post
                     JOIN account ON community_post.userId = account.id
            ORDER BY postTime DESC""")
    List<CommunityPost> getAllPosts();

    // 发帖
    @Insert("INSERT INTO community_post (userId, content) VALUE (#{userId}, #{content})")
    int CreateNewPost(int userId, String content);

    @Select("""
            SELECT community_post.id,
                   community_post.userId,
                   account.username,
                   community_post.postTime,
                   community_post.content
            FROM community_post
                     JOIN account ON community_post.userId = account.id
            WHERE community_post.id = #{postId}""")
    CommunityPost getPostById(int postId);

    // 删除帖子
    @Delete("DELETE FROM community_post WHERE id = #{postId}")
    int DeletePostById(int postId);

    // 获取最新帖子 ID
    @Select("SELECT id FROM community_post ORDER BY id DESC LIMIT 1")
    int getLatestPostId();
}
