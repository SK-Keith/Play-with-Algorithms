package kgyy.com.keith.huadong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * @author yaomianxian
 * @date 2025/11/26 0026 10:51
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) return result;

        // 统计p的字符频率
        int[] pCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // 初始化窗口字符频率
        int[] window = new int[26];
        for (int i = 0; i < pLen; i++) {
            window[s.charAt(i) - 'a']++;
        }

        // 检查第一个窗口
        if (Arrays.equals(pCount, window)) {
            result.add(0);
        }

        // 滑动窗口
        for (int i = pLen; i < sLen; i++) {
            // 移除左边字符
            window[s.charAt(i - pLen) - 'a']--;
            // 添加右边字符
            window[s.charAt(i) - 'a']++;

            // 检查当前窗口
            if (Arrays.equals(pCount, window)) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }

    public List<Integer> findAnagramsOpt(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return result;
        }

        // 初始化，p中的字符+1，s中前pLen个字符-1
        int[] count = new int[26];
        for(int i = 0; i < pLen; i++) {
            count[p.charAt(i) - 'a']++;
            count[s.charAt(i) - 'a']--;
        }

        // 检查差异是否为0，不平衡计数器
        int diff = 0;
        for (int num : count) {
            if (num != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            result.add(0);
        }

        // 滑动窗口
        for (int i = pLen; i < sLen; i++) {
            char leftChar = s.charAt(i - pLen);
            char rightChar = s.charAt(i);

            // 原本平衡和原本不平衡是不可能同时存在的，diff++表示加了之后
            // 移除左字符
            if (count[leftChar - 'a'] == 0) {
                // 原本平衡了，现在不平衡
                diff ++;
            }
            count[leftChar - 'a']++;
            if (count[leftChar - 'a'] == 0) {
                // 原本不平衡，现在平衡了
                diff--;
            }

            // 添加右字符
            if (count[rightChar - 'a'] == 0) {
                diff ++;
            }
            count[rightChar - 'a']++;
            if (count[rightChar - 'a'] == 0) {
                diff --;
            }

            if (diff == 0) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }
}
