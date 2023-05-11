package com.tootaio.gameofficialbackend.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostHashtagMapper {
    @Insert("INSERT INTO post_hashtag (postId, hashtagId, postType) VALUE (#{communityPostId}, #{hashtagId}, 'community')")
    int connectCommunityPostAndHashtag(int communityPostId, int hashtagId);

    @Select("""
            SELECT tagName
            FROM post_hashtag
                     JOIN hashtags on post_hashtag.hashtagId = hashtags.id
            WHERE postId = #{communityPostId}
              AND postType = 'community'""")
    List<String> getHashtagsByCommunityPostId(long communityPostId);

    @Insert("INSERT INTO post_hashtag (postId, hashtagId, postType) VALUE (#{blogPostId}, #{hashtagId}, 'blog')")
    int connectBlogPostAndHashtag(int blogPostId, int hashtagId);

    @Select("""
            SELECT tagName
            FROM post_hashtag
                     JOIN hashtags on post_hashtag.hashtagId = hashtags.id
            WHERE postId = #{blogPostId}
              AND postType = 'blog'""")
    List<String> getHashtagsByBlogPostId(long blogPostId);
}
