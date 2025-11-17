package kgyy.com.keith.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/16 0016 13:18
 */
public class Daily2 {

    /**
     * 错误版本
     * @param nums
     * @return
     */
    public static int[] dailyTemError(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (!deque.isEmpty() && nums[i] > nums[deque.peek()]) {
                Integer pop = deque.pop();
                int res = i - pop;
                result[pop] = res;
            }
            deque.push(i);
        }
        return result;
    }

    public static int[] dailyTem(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int tem = nums[i];
            while (!deque.isEmpty() && tem > nums[deque.peek()]) {
                Integer pop = deque.pop();
                int res = i - pop;
                result[pop] = res;
            }
            deque.push(i);
        }
        return result;
    }
}
