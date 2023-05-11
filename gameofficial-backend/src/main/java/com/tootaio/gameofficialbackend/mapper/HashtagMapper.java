package com.tootaio.gameofficialbackend.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HashtagMapper {
    @Select("SELECT COUNT(*) FROM hashtags WHERE tagName = #{hashtag}")
    int checkHashtagExists(String hashtag);

    @Insert("INSERT INTO hashtags (tagName) VALUE (#{hashtag})")
    int createHashtag(String hashtag);

    @Select("SELECT id FROM hashtags WHERE tagName = #{hashtag}")
    int getHashtagId(String hashtag);
}
