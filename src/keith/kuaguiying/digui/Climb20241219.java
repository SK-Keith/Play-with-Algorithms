package com.keith.digui;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/19 0019 13:27
 */
public class Climb20241219 {

    /**
     * 使用递归解法
     * @param n
     * @return
     */
    public static int climb(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climb(n-1) + climb(n - 2);
    }

    /**
     * 优化递归解法，存储子问题的解
     * @param n
     * @return
     */

    public static Integer[] memo;
    public static int climb2(int n) {
        memo = new Integer[n+1];
        return clumb2Memo(n);
    }

    public static int clumb2Memo(int n) {
        if (n <= 2) {
            return n;
        }
        if (memo[n] != null && memo[n] != 0) {
            return memo[n];
        }
        return clumb2Memo(n -1) + clumb2Memo(n -2);
    }


    /**
     * 使用动态规划
     * @param n
     * @return
     */
    public static int climb3(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[0] = 1;
        for(int i = 2;i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * 动态规划优化，省略空间
     * @param n
     * @return
     */
    public static int climb4(int n) {
        int pre = 1, next = 1;
        for (int i = 2;i <= n;i++) {
            int temp = pre + next;
            pre = next;
            next = temp;
        }
        return next;
    }
}
