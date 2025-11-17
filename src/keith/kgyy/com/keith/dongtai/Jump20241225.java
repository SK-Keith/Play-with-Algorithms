package kgyy.com.keith.dongtai;

/**
 * 能跳到最后位置使用的最少跳跃数
 *
 * @author yaomianxian
 * @date 2024/12/25 0025 14:18
 */
public class Jump20241225 {
    /**
     * 贪心算法实现，每个位置都计算出最长能到达的距离，在这段距离内寻找更远的距离，
     *  以此类推，每次到达范围内最大的距离时再跳一次
     * @param nums
     * @return
     */
    public static int jumpGreedyError(int[] nums) {
        int jump = 0;
        int end = 0;
        int n = nums.length;
        int farmost = 0;
        for(int i = 0;i<n-1;i++) {
            farmost = Math.max(i + nums[i], farmost);
            if (i <= end) {
                jump++;
                end = farmost;
                if (end >= n -1) {
                    return jump;
                }
            }
        }
        return jump;
    }

    public static int jumpGreedy(int[] nums) {
        int jump = 0;
        int end = 0;
        int n = nums.length;
        int farmost = 0;
        for(int i = 0;i<n-1;i++) {
            farmost = Math.max(i + nums[i], farmost);
            if (i == end) {
                jump++;
                end = farmost;
                if (end > n -1) {
                    break;
                }
            }
        }
        return jump;
    }

    /**
     * 没掌握
     * @param nums
     * @return
     */
    public static int jumpDP(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1;i < n;i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0;i<n ;i++) {
            if (dp[i] == Integer.MAX_VALUE)
                continue;
            for (int j = i+1;j<=nums[i] + i && j<n;j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[n - 1];
    }

}
