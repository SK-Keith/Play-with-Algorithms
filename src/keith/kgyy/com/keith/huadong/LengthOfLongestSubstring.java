package kgyy.com.keith.huadong;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/submissions/680756202/?envType=study-plan-v2&envId=top-100-liked
 * 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 *
 * @author yaomianxian
 * @date 2025/11/26 0026 9:46
 */
public class LengthOfLongestSubstring {
    /**
     * 滑动窗口（双指针）法
     * 维护一个窗口 [left, right]，用 HashSet 或 HashMap 记录窗口内字符：
     * 右指针 right向右移动，扩大窗口
     * 如果遇到重复字符，左指针 left向右移动，缩小窗口，直到无重复
     * 记录窗口大小的最大
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while(set.contains(c)) {
                // 重点是s.charAt(left)，删除
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            max = Math.max(max, (right - left + 1));
        }
        return max;
    }

    public int lengthOfLongestSubstringHashMap(String s) {
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
