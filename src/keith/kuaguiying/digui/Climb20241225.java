package com.keith.digui;

/**
 * 每次一个或两个台阶，求爬到n级台阶需要的方法数
 *
 * @author yaomianxian
 * @date 2024/12/25 0025 13:37
 */
public class Climb20241225 {
    /**
     * 递归法遍历，时间复杂度为O(2^n),空间复杂度为O(n)!!!空间复杂度是O(n)
     * 递归方法的空间复杂度实际上是O(n)，而不是O(1)。原因是递归会在调用栈上消耗空间，每一层递归都会消耗一定的栈空间。
     * 因此，空间复杂度是递归深度，即O(n)。
     * @param n
     * @return
     */
    public static int climb(int n) {
        if (n <= 2) {
            return n;
        }
        return climb(n-1) + climb(n-2);
    }

    /**
     * 递归法，存储子问题的解， 时间复杂度为O(2^n),空间复杂度为O(n)
     * @param n
     * @return
     */
    public static int[] memo;
    public static int climb2(int n) {
        memo = new int[n + 1];
        return climb2(n, memo);
    }

    public static int climb2(int n, int[] memo) {
        if (n <= 2) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        return climb2(n - 1, memo) + climb2(n - 2, memo);
    }


    /**
     * 动态规划解法，时间复杂度O(n),空间复杂度O(n)
     * @param n
     * @return
     */
    public static int climb3Error(int n) {
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;

        for (int i = 2; i < n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    public static int climb3(int n) {
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    /**
     * 优化动态规划，省略空间，时间复杂度O(n)，时间复杂度O(1)
     * @param n
     * @return
     */
    public static int climb4Error(int n) {
        if (n <= 2) {
            return n;
        }
        int cur = 1, next = 1;
        for (int i = 2;i< n;i++) {
            int temp = next;
            cur = next;
            next = cur + next;
        }
        return next;
    }

    public static int climb4(int n) {
        if (n <= 2) {
            return n;
        }
        int cur = 1, next = 2;
        for (int i = 3;i<= n;i++) {
            int temp = next;
            next = cur + next;
            cur = temp;
        }
        return next;
    }



}
