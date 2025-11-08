package com.keith.dongtai;

public class Jump20250307 {
	public static int jumpGreedy(int[] nums) {
		int n = nums.length;
		int end = 0;
		int jump = 0;
		int farmost= 0;
		// error:nums.length 改成 nums.length - 1，只最大范围
		for(int i =0;i<n - 1;i++) {
			farmost = Math.max(i+nums[i], farmost);
			if (i == end) {
				end = farmost;
				jump++;
				// error2：i >= n-1 改成 end > nums.length - 1，是当前已到了终点（最后一个位置）
				if (end > n - 1) {
					break;
				}
			}
			// error3: 如果当前位置值是0，则不可跳跃
			if (nums[i] == 0 && i == end) {
				return Integer.MAX_VALUE;
			}
		}
		return jump;
	}


	public static int jumpDP(int[] nums) {
		int n = nums.length;
		if (n <= 1) return 0;

		int[] dp = new int[n];
		dp[0] = 0;

		for(int i = 1;i<n;i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		for(int i = 0;i<n;i++) {
			if (dp[i] == Integer.MAX_VALUE) continue;
			for(int j = i+1;j<=nums[i] + i && j < n;j++) {
				dp[j] = Math.min(dp[j], dp[i] + 1);
			}
		}

		return dp[n - 1];
	}
}
