package kgyy.com.keith.dongtai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.marscode.cn/practice/r389k53ddp0rjr?
 * 问题描述
 * 小R正在计划一次从地点A到地点B的徒步旅行，总路程需要 N 天。为了在旅途中保持充足的能量，小R每天必须消耗1份食物。
 * 幸运的是，小R在路途中每天都会经过一个补给站，可以购买食物进行补充。然而，每个补给站的食物每份的价格可能不同，并且小R最多只能同时携带 K 份食物。
 *
 * 现在，小R希望在保证每天都有食物的前提下，以最小的花费完成这次徒步旅行。你能帮助小R计算出最低的花费是多少吗？
 * 测试样例
 * 样例1：
 *
 * 输入：n = 5 ,k = 2 ,data = [1, 2, 3, 3, 2]
 * 输出：9
 *
 * 样例2：
 *
 * 输入：n = 6 ,k = 3 ,data = [4, 1, 5, 2, 1, 3]
 * 输出：9
 *
 * 样例3：
 *
 * 输入：n = 4 ,k = 1 ,data = [3, 2, 4, 1]
 * 输出：10
 * @author yaomianxian
 * @date 2024/11/26 0026 9:50
 */
public class Supply {
    public static int solution1(int n, int k, int[] data) {
        // dp[i]表示从第1天到第i天的最低花费
        int[] dp = new int[n + 1];
        dp[0] = 0; // 第0天没有花费

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE; // 初始化为一个大数，表示当前状态尚不可达

            // 尝试从前面最多K天中选择购买食物，确保每天都有食物
            for (int j = Math.max(0, i - k); j < i; j++) {
                // 从第j天购买食物，并计算从第j天到第i天的最小花费
                dp[i] = Math.min(dp[i], dp[j] + data[j]);
                System.out.println("i="+i+",dp:" +dp[i]);
            }
        }

        return dp[n];  // 返回从第1天到第n天的最低花费
    }


    public static int solution2(int n, int k, int[] data) {
        // dp[i][j]表示到第i天，携带j份食物时的最小花费
        int[][] dp = new int[n + 1][k + 1];

        // 初始化dp数组为最大值
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = 0;  // 第0天没有花费，携带0份食物

        // 遍历每一天
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (dp[i-1][j] != Integer.MAX_VALUE) {
                    // 如果前一天是有效的状态
                    // 从第i天开始购买食物，更新dp[i][j]
                    // i天需要1份食物，最多携带K份
                    for (int m = 0; m <= k-j; m++) {
                        dp[i][j + m] = Math.min(dp[i][j + m], dp[i-1][j] + data[i-1] * m);
                    }
                }
            }
        }

        return dp[n][0];  // 最终在第n天携带0份食物时的最小花费
    }

    /**
     * 贪心算法，维护一个k的链表，存储从0到k的价格表，用于在第i天获取最小的花费
     * @param n
     * @param k
     * @param data
     * @return
     */
    public static int solution(int n, int k, int[] data) {
        int minMoney = 0;
        LinkedList<Integer> ready = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // 当前站点加入ready
            ready.add(data[i]);

            // 如果ready大于k，就将最先进入的站点价格删除
            if (ready.size() > k) {
                ready.removeFirst();  // 删除最早进入的元素
            }

            // 找到最小值
            int minValue = Collections.min(ready);  // 找到当前队列中的最小值
            minMoney += minValue;  // 累加到总花费
        }

        return minMoney;
    }

    public static int solution3(int n, int k, int[] data) {
        int minMoney = 0;
        LinkedList<Integer> allow = new LinkedList<>();
        for(int i = 0;i<n;i++) {
            allow.add(data[i]);
            if (allow.size() > k) {
                allow.removeFirst();
            }

            Integer min = Collections.min(allow);
            minMoney += min;
        }
        return minMoney;
    }

    public static void main(String[] args) {
        // Add your test cases here
        int solution = solution3(5, 2, new int[]{1, 2, 3, 1, 3});
        System.out.println(solution);
        System.out.println(solution == 9);
    }
}
