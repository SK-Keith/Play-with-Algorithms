package kgyy.com.keith.huadong;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/11/26 0026 10:46
 */
public class lengthOfLongestSubstring20251126 {

    public int lengthOfLongestSubstring(String s) {
        int max = 0, left = 0;
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
