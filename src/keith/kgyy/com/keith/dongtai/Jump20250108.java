package kgyy.com.keith.dongtai;

public class Jump20250108 {

	/**
	 * 贪心算法
	 * 每一步中，贪心的选择是能跳到最远的距离
	 * 当前跳跃区间结束后，我们才真正需要再跳一步，并在下一个跳跃区间内选择最远的距离
	 */
	public static int jumpGreedy(int[] nums) {
		int farest = 0;
		int end = 0;
		int jump = 0;

		for(int i = 0;i<nums.length - 1;i++) {
			farest = Math.max(nums[i] + i, farest);

			if (i == end) {
				end = farest;
				jump++;
				if (end > nums.length - 1) {
					break;
				}
			}
			if (i == end && nums[i] == 0) {
				return Integer.MAX_VALUE;
			}
		}
		return jump;
	}

	public static int jumpDP(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return 0;
		}

		int[] dp = new int[n];
		dp[0] = 0;

		for(int i = 1;i<n;i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		for(int i = 0;i<n;i++) {
			if (dp[i] == Integer.MAX_VALUE)
				continue;
			for(int j = i+1;j<=nums[i] + i && j < n;j++) {
				dp[j] = Math.min(dp[j], dp[i] + 1);
			}
		}
		return dp[n - 1];

	}
}
