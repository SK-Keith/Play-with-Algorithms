package kgyy.com.keith.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/11/12 0012 16:01
 */
public class DailyTem20251112 {

    public int[] dailyTem(int[] tems) {
        int length = tems.length;
        int[] ans = new int[length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0;i<tems.length;i++) {
            int tem = tems[i];
            while(!deque.isEmpty() && tem > tems[deque.peek()]) {
                Integer index = deque.pop();
                ans[index] = i - index;
            }
            deque.push(i);
        }
        return ans;
    }
}
