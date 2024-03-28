package shuangzhizhen.huadong;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MX.Y
 * @DATE 2022-05-30 22:43
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        int length = chars.length;
        // 必要的存储
        Map<Character, Integer> window = new HashMap<>();
        int res = 0;
        while(right < length) {
            // 即将移入窗口的字符
            char c = chars[right];
            // 增大窗口
            right++;
            // 加入字符后，应该更新存储
            if (window.containsKey(c)) {
                window.put(c, Integer.parseInt(String.valueOf(window.get(c))) + 1);
            } else {
                window.put(c, 1);
            }
            // 什么条件下，窗口应该暂停扩大，开始移动left缩小窗口？当存储中出现多个相同的数据时
            while(window.containsKey(c) && Integer.parseInt(String.valueOf(window.get(c))) > 1) {
                // 取出缩小窗口时的元素
                char d = chars[left];
                // 缩小窗口
                left++;
                // 减少字符后，应该更新存储
                window.put(d, Integer.parseInt(String.valueOf(window.get(d))) - 1);
            }
            // 得到最优解
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        int i = l.lengthOfLongestSubstring(s);
        System.out.println(i);
    }



}
