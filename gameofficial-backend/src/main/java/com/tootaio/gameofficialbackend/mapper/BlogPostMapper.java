package com.tootaio.gameofficialbackend.mapper;

import com.tootaio.gameofficialbackend.entity.BlogPost;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BlogPostMapper {
    @Select("""
            SELECT *
            FROM blog_post
            ORDER BY postTime desc""")
    List<BlogPost> getAllPost();

    @Insert("INSERT INTO blog_post (userId, title, content) VALUE (#{userId}, #{title}, #{content})")
    int createNewPost(long userId, String title, String content);

    @Update("""
            UPDATE blog_post
            SET title   = #{title},
                content = #{content},
                updateTime = CURRENT_TIMESTAMP
            WHERE id = #{postId}""")
    int updatePost(String title, String content, long postId);

    @Select("""
            SELECT * FROM blog_post WHERE blog_post.id = #{postId}""")
    BlogPost getPostById(long postId);

    // 删除帖子
    @Delete("DELETE FROM blog_post WHERE id = #{postId}")
    int DeletePostById(long postId);

    // 获取最新帖子 ID
    @Select("SELECT id FROM blog_post ORDER BY id DESC LIMIT 1")
    int getLatestPostId();

    // TODO: 修改帖子
}
