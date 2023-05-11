package com.tootaio.gameofficialbackend.mapper;

import com.tootaio.gameofficialbackend.entity.BlogPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlogPostMapper {
    @Select("""
            SELECT *
            FROM blog_post
            ORDER BY postTime desc""")
    List<BlogPost> getAllPost();
}
