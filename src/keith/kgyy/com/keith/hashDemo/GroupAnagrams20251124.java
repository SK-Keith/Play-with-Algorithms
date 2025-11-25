package kgyy.com.keith.hashDemo;

import java.util.*;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/11/24 0024 11:32
 */
public class GroupAnagrams20251124 {
    public List<List<String>> groupAnagrams(String[] arrays) {
        Map<String, List<String>> map = new HashMap<>();
        for (String array : arrays) {
            char[] chars = array.toCharArray();
            Arrays.sort(chars);
            String newStr = new String(chars);
            if (!map.containsKey(newStr)) {
                List<String> arrs = new ArrayList<>();
                arrs.add(array);
                map.put(newStr, arrs);
            } else {
                map.get(newStr).add(array);
            }
        }
        return new ArrayList<>(map.values());
    }
}
