package com.wu.array.lengthoflongestsubstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode3-无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //暴力匹配，时间复杂度0(n²)
        /*if (s.length() == 0 || s == ""){
            return 0;
        }
        int max = 1;
        int maxLength = 1;
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        int index = 1;
        while (index < chars.length) {
            list.add(chars[index - 1]);
            for (int i = index; i < chars.length; i++) {
                if (!list.contains(chars[i])) {
                    list.add(chars[i]);
                    max++;
                }else {
                    break;
                }
            }
            if (max > maxLength) {
                maxLength = max;
            }
            list.clear();
            max = 1;
            index++;
        }
        return maxLength;
         */
        //解法二：时间复杂度0(n)
        int maxSize = 0;
        int[] dict = new int[128]; //记录ASCII 码字符出现的位置，以字符作为下标
        int base = 0;
        int key = 0;
        int i = 0;
        while (key < s.length()) {
            i = s.charAt(key);
            if (dict[i] > base) {
                base = dict[i];
            }
            dict[i] = key + 1; //以1作为起始位置，下标加1
            maxSize = (maxSize > key - base + 1) ? maxSize : key - base + 1;
            key++;
        }
        return maxSize;
    }
}