package com.keith.digui;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * https://leetcode.cn/problems/climbing-stairs/description/
 * climbStairs(1) = 1
 * climbStairs(2) = 2
 * climbStairs(3) = climbStairs(2) + climbStairs(1) = 2 + 1 = 3
 * climbStairs(4) = climbStairs(3) + climbStairs(2) = 3 + 2 = 5
 *
 * @author yaomianxian
 * @date 2024/08/6 0006 20:20
 */
public class Climb {

    /**
     * 递归法遍历，时间复杂度为O(2^n),空间复杂度为O(n)
     * **时间复杂度：**该算法的时间复杂度是 O(2^n)。这是因为每一级递归都会生成两个新的递归调用（除了基本情况），
     * 从而构成一个二叉树的递归调用结构。在这个二叉树中，每个节点都会进行一次递归调用，
     * 除了叶子节点（基本情况），因此总共有 2^n - 1 个节点，每个节点对应一次递归调用。
     * 由于每次递归调用中进行的操作数是常数，因此整个算法的时间复杂度由递归调用的次数决定，即 O(2^n)。
     * **空间复杂度：**空间复杂度是 O(n)，这是因为递归过程中，系统需要使用栈来存储每一层递归调用的信息。
     * 在最坏的情况下，递归调用栈的深度会达到 n，即当递归到最底层然后依次返回的时候。因此，空间复杂度与输入的楼梯阶数 n 成线性关系。
     * 在实际应用中通常会采用动态规划方法（如之前的迭代方法或记忆化递归）来优化性能。
     * 动态规划和递归之间有着密切的关系。实际上，动态规划通常可以看作是递归的一种优化手段。
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
        return climb(n -1) + climb(n - 2);
    }

    /**
     * 带记忆化的递归法，时间复杂度为O(n)，空间复杂度为O(n)
     * 递归法，存储子问题的解
     * 使用了一个Memo数组来存储每一个子问题的解，计算子问题时，检查memo数组中是否有这个子问题的解，如果有，就直接返回，避免重复计算
     * 将递归的时间复杂度降到了O(n)，而空间复杂度也变成了O（n），这也是我们需要额外的空间来存储子问题的解。
     */
    private static Integer[] memo;

    public static int climb2(int n) {
        memo = new Integer[n + 1];
        return climb2Memo(n);
    }

    private static int climb2Memo(int n) {
        if (n <= 2) {
            return n;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        memo[n] = climb2Memo(n - 1) + climb2Memo(n - 2);
        return memo[n];
    }

    /**
     * 动态规划阶梯解法，时间复杂度O(n),空间复杂度O(n)
     */
    public static int climb3(int n) {
        // 12.19 漏了这个初始化逻辑
        // 02.06 将初始值改成n <=2，dp[0] = 1，dp[1]= 1
        if (n <= 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // 12.19 错在这个等于n，因为返回的dp[n]
        for(int i = 2;i<=n;i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 时间复杂度O(n),空间复杂度O(1)
     * 动态规划的基础上，因为我们只需计算出结果，不需要过程，所以可以优化空间
     */
    public static int climb4(int n) {
        if (n <= 1) {
            return 1;
        }
        int prev2 = 1, prev1 = 1;
        for(int i = 2;i<=n;i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int n = 5; // 举例，楼梯的级数为 5
        System.out.println("Number of ways to climb " + n + " stairs: " + Climb.climb(n));

        System.out.println("Number of ways to climb " + n + " stairs: " + Climb.climb2(n));

        System.out.println("Number of ways to climb " + n + " stairs: " + Climb.climb3(n));

        System.out.println("Number of ways to climb " + n + " stairs: " + Climb.climb4(n));
    }


}
