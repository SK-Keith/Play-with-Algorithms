package kgyy.com.keith.valid;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/04/3 0003 17:06
 */
public class Solution {

    private static final Map<Character, Character> map = new HashMap<>(){{
        put('(', ')');
        put('[', ']');
        put('{', '}');
        put('?', '?');
    }};

    public boolean isValid(String s) {
        if (s.length() <= 0 || !map.containsKey(s.charAt(0))) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>(){{
            add('?');
        }} ;
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.add(c);
            } else if (map.get(stack.removeLast()) != c) {
                return false;
            }
        }
        return stack.size() == 1;
    }
}
