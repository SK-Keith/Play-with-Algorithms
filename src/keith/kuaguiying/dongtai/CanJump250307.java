package com.keith.dongtai;

public class CanJump250307 {
	/**
	 * 贪心
	 * @param nums
	 * @return
	 */
	public static boolean canjump(int[] nums) {
		int farmost = 0;
		int n = nums.length;
		for(int i = 0;i<n;i++) {
			if (i <= farmost) {
				farmost = Math.max(farmost, i +nums[i]);
				if (farmost >= n - 1) {
					return true;
				}
			}
		}
		return false;
	}
}
