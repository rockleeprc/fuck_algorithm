package com.leetcode;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 小积累
 */
public class T {
    /**
     * 提取字##中的符串
     */
    @Test
    public void t1() {
        String regex = "#([^#]+)#";
        String str = "#你好#，不好#嗷嗷#史蒂夫";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
