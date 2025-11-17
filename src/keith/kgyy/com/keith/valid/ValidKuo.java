package kgyy.com.keith.valid;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/04/9 0009 13:43
 */
public class ValidKuo {

    public static Map<Character, Character> map = new HashMap<>(){{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    public static boolean isValid(String str) {
        if (str.length() <= 0 || !map.containsKey(str.charAt(0))) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>() {{
            add('?');
        }};
        char[] ss = str.toCharArray();
        for(char s : ss) {
            if (map.containsKey(s)) {
                stack.add(s);
            } else if (!Objects.equals(map.get(stack.removeLast()), s)) {
                return false;
            }
        }
        return stack.size() == 1;
    }
}
