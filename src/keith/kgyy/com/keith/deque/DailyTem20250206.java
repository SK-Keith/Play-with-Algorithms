package kgyy.com.keith.deque;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTem20250206 {
    public int[] dailyTem(int[] nums) {
        int length = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[length];
        // i < length - 1 改成 i < length
        for (int i = 0; i < length; i++) {
            int temp = nums[i];
            // 温度更大才会被打败，所以是temp更大
            while (!deque.isEmpty() && nums[deque.peek()] < temp) {
                Integer j = deque.pop();
                // ans的下标是当前打赢的下标，即j
                // int a = i - j;
                // ans[a] = nums[i] - temp;
                ans[j] = i - j;
            }
            deque.push(i);
        }
        return ans;
    }
}
