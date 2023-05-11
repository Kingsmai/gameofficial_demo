package com.tootaio.gameofficialbackend.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HashtagExtractor {
    public static List<String> extract(String content) {
        List<String> hashtags = new ArrayList<>();

        // 使用正则表达式匹配 Hashtag
        Pattern pattern = Pattern.compile("#[\\p{L}0-9_]+");
        Matcher matcher = pattern.matcher(content);

        // 遍历匹配结果，并将提取到的 Hashtag 添加到列表中
        while (matcher.find()) {
            String hashtag = matcher.group().substring(1); // 去掉 "#" 字符
            hashtags.add(hashtag);
        }

        return hashtags;
    }
}
