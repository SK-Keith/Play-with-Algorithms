package kgyy.com.keith.valid;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/04/1 0001 17:18
 */
public class Solution2 {

    private static final Map<Character, Character> map = new HashMap<Character, Character>(){{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }} ;

    public static boolean isValid(String s) {
        if (s.length() <= 0 || !map.containsKey(s.charAt(0))) {
            return false;
        }

        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }} ;

        for(Character c : s.toCharArray()) {
            if(map.containsKey(c)) {
                stack.add(c);
            } else if (map.get(stack.removeLast()) != c){
                return false;
            }
        }
        return stack.size() == 1;
    }

    public static void main(String[] args) {
        String s = "()[{]";
        System.out.println(isValid(s));
    }
}
