package shuangzhizhen.huadong;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MX.Y
 * @DATE 2022-06-01 7:22
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            if (need.containsKey(c)) {
                need.put(c, need.get(c) + 1);
            } else {
                need.put(c, 1);
            }
        }

        int left = 0, right = 0;
        int valid = 0;
        char[] chars = s2.toCharArray();
        while(right < s2.length()) {
            char c = chars[right];
            right++;
            // 加入字符后，应该更新存储
            if (need.containsKey(c)) {
                // 加入字符后，应该更新存储
                if (window.containsKey(c)) {
                    window.put(c, Integer.parseInt(String.valueOf(window.get(c))) + 1);
                } else {
                    window.put(c, 1);
                }
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while(right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = chars[left];
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidboaoo";
        CheckInclusion c = new CheckInclusion();
        boolean b = c.checkInclusion(s1, s2);
        System.out.println(b);
    }
}
