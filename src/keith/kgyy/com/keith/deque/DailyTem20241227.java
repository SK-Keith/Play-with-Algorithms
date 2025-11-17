package kgyy.com.keith.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/27 0027 13:58
 */
public class DailyTem20241227 {

    public static int[] dailyTemError(int[] nums) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[n];
        for(int i = 0;i<n;i++) {
            int tem = nums[i];
            while(!deque.isEmpty() && tem > nums[deque.pop()]) {
                Integer index = deque.peek();
                ans[index] = i - index;
            }
            deque.push(i);
        }
        return ans;
    }

    public static int[] dailyTem(int[] nums) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[n];
        for(int i = 0;i<n;i++) {
            int tem = nums[i];
            while(!deque.isEmpty() && tem > nums[deque.peek()]) {
                Integer index = deque.pop();
                ans[index] = i - index;
            }
            deque.push(i);
        }
        return ans;
    }
}
