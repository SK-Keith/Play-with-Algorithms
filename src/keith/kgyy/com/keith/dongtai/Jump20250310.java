package kgyy.com.keith.dongtai;

public class Jump20250310{

	public static int jumpGreedy(int[] nums) {
		// error lenth() 改成length
		int n = nums.length;
		int jump = 0;
		int end = 0;
		int farest = 0;
		for(int i = 0;i<n -1;i++) {
			farest = Math.max(i + nums[i], farest);
			if (i == end) {
				jump ++;
				end = farest;
				if (end > n - 1) {
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
		if (n == 1) return 0;

		int[] dp = new int[n];
		dp[0] = 0;

		// error少加了这个逻辑
		for(int i = 1;i<n;i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		// error i= 1 改成 i= 0
		for(int i = 0;i<n;i++) {
			// error 少加了这个逻辑
			if (dp[i] == Integer.MAX_VALUE) continue;
			// error dp[i] + 1 改成 nums[i] + 1
			// error j < nums[i] + 1 改成 j <= nums[i] + 1，可以等于
			for(int j = i + 1; j <= nums[i] + 1 && j < n;j++) {
				dp[j] = Math.min(dp[i] + 1, dp[j]);
			}
		}

		return dp[n - 1];
	}
}
