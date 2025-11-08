package com.keith.dongtai;

/**
 * 动态规划-贪心算法
 * 给你一个非负整数数组nums，你最初位于数组的第一个位置，数组中的每个元素代表你在该位置可以跳跃最大长度，
 * 请你使用最少的跳跃次数到达数组的最后一个位置（假设你总是可以到达数组的最后一个位置）。
 * 示例1：输入：nums=[2,3，1，1,4]输出：2
 * 解释：跳到最后一个位置的最小跳跃数是2。从下标为0跳到下标为1的位置，跳1步，然后跳3步到达数组的最后一个位置
 * 疑惑1：遍历到nums.length不行？因为非负！nums.length - 1也是非负
 *      我们的目标是从数组的第一个位置（即索引 0）跳（重点是我们在nums.length - 1 -1 的位置跳了一次到了nums.length - 1）到数组的 最后一个位置，
 *      而不是跳到数组的末尾（在最后一个元素不用调了，所以不需要遍历了）。
 * 在每一步中，贪心策略选择的是能跳到的 最远位置。也就是说，当前跳跃区间结束后，我们选择下一跳的最远目标，以减少跳跃次数。
 * @author yaomianxian
 * @date 2024/11/26 0026 14:18
 */
public class Jump {
    /**
     * 每次直接跳到能覆盖最远的位置
     * 力扣45题（也可以使用动态规划）解题难度	更复杂（需要跟踪跳跃次数）	相对第55题简单（只需要判断是否能到达）
     * 计算最少多少步能到达数组的最后一个位置
     * 也是使用贪心算法，（也可以使用动态规划）
     * 区别于是否能跳，这个最少多少步，
     *              一是需要步数；
     *              二是需要每次的最远距离；
     *              三是当前已到达的最远距离（用于跳下一步）
     * 截止条件：当前已到达的最远距离大于数组的最后第二个位置
     * @param nums
     * @return,
     */
    public static int jumpGreedy(int[] nums) {
        // 定义最优结果
        int farthest = 0;
        int end = 0;
        int jumps = 0;

        for(int i = 0;i<nums.length - 1;i++) {
            farthest = Math.max(nums[i] + i, farthest);
            // 如果当前的位置到达了当前跳跃的最远位置
            // 第一次跳是在初始位置，即i=0；第二次跳是在第一次能跳的范围内选择最大的位置跳
            // 类比与Supply.java题目中，补给后k范围内的最便宜的补给，都是在某个范围内最优的选择
            if (i == end) {
                end = farthest;
                // 跳，想象当前在nums.lenth - 1 - 1的位置，跳到了下一个位置（jumps+1了），也就是nums.length-1，也就不需要再跳了，出循环
                jumps++;

                if (end > nums.length - 1) {
                    break;
                }
            }
            // 如果在某一步i 的位置无法到达下一个位置，则说明无法跳跃到最后
            if (i == end && nums[i] == 0) {
                return Integer.MAX_VALUE;
            }
        }
        return jumps;
    }

    /**
     * 动态规划，记录每个位置的最小步数
     * 动态规划的核心是：把大问题拆成小问题，记录中间结果，避免重复计算
     * 它通过维护一个 dp 数组，其中 dp[i] 表示到达第 i 个位置的最少跳跃次数！！！
     * 我们通过双重循环计算每个位置的最少跳跃次数。
     * @param nums
     * @return
     */
    public static int jumpDP(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        // dp[i] 标识到达位置i的最小跳跃次数
        int[] dp = new int[n];
        dp[0] = 0;

        // 初始化其他位置为一个较大的数
        for(int i =1;i<n;i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // 动态规划计算最小跳跃次数
        // dp[i]：表示从起点跳到位置 i 所需要的最小跳跃次数
        for(int i= 0;i < n;i++) {
            // 当前能跳跃的最远位置是nums[i] 步
            if (dp[i] == Integer.MAX_VALUE) continue; // 如果当前位置无法到达，则跳过
            for(int j = i+1;j<=nums[i] + i && j < n;j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        // 最终到达嘴壶一个位置所需的最小跳跃次数
        return dp[n - 1];
    }

    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false
     *
     * 判断是否能跳关键在于跳的距离大于给定长度
     * 使用贪心算法实现
     * 如果某一时刻的最远距离超过或等于数组的最后一个位置，则说明可以跳到
     * 如果当前位置i超过了最远距离，说明无法到达该位置，也就不能到达最后的位置
     * @param nums
     * @return
     */
    public static boolean canjump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(i + nums[i], rightmost);
                // 必须使用>=，因为存在数组就是0的，要返回true
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
