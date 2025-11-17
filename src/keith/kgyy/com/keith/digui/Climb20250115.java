package kgyy.com.keith.digui;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/01/15 0015 13:38
 */
public class Climb20250115 {
    // 递归，时间O(2^n) 空间O(n)
    public static int climb(int n) {
        if (n <= 2) {
            return n;
        }
        return climb(n - 1) + climb(n - 2);
    }


    public static Integer[] memo;
    public static int climb2(int n) {
        memo = new Integer[n+1];
        memo[1] = 1;
        memo[2] = 2;
        return climb2(n, memo);
    }

    public static int climb2(int n, Integer[] memo) {
        if (n <= 2) {
            return n;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        memo[n] = climb2(n - 1, memo) + climb2(n - 2, memo);
        return memo[n];
    }

    public static int climb3(int n) {
        int[] nums = new int[n+1];
        nums[1] = 1;
        nums[2] = 2;
        for(int i = 3;i<= n;i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

    public static int climb4(int n) {
        if (n <= 2) {
            return n;
        }
        int pre = 1;
        int cur = 2;
        for(int i = 3;i <= n;i++) {
            int temp = cur;
            cur = pre + cur;
            pre = temp;
        }
        return cur;
    }
}
