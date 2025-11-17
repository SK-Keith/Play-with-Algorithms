package kgyy.com.keith.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/01/15 0015 13:28
 */
public class DailyTem20250115 {

    public int[] dailyTem(int[] nums) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[n];
        for (int i = 0;i< n;i++) {
            int tem = nums[i];
            while(!deque.isEmpty() && nums[deque.peek()] < tem) {
                Integer pop = deque.pop();
                ans[pop] = i - pop;
            }
            deque.push(i);
        }
        return ans;
    }
}
