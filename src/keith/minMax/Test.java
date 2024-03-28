package minMax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MX.Y
 * @DATE 2021/11/24 0:38
 * @qq 2690399241
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(11);
        map.put(1, list);
        if (map.containsKey(1)) {
            System.out.println(11);
        }
    }
}
