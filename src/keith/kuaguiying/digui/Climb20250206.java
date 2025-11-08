package com.keith.digui;

public class Climb20250206 {
	// 递归法，时间：O(2^n)，空间O(n)
	public static int climb(int n) {
		if (n <= 2) {
			return n;
		}
		return climb(n - 1) + climb(n - 2);
	}

	public static Integer[] memo;

	// 带记忆法的递归法，时间O(n)，空间O(n)
	public static int climb2(int n) {
		memo = new Integer[n + 1];
		return climb2Memo(n, memo);
	}


	private static int climb2Memo(int n, Integer[] memo) {
		if (n <= 2) {
			return n;
		}
		if (memo[n] != null) {
			return memo[n];
		}
		return climb2Memo(n-1, memo) + climb2Memo(n-2, memo);
	}

	// 动态规划，时间O(n)，空间O(n)
	public static int climb3(int n) {
		if (n <= 2) {
			return n;
		}
		int[] memo = new int[n + 1];
		memo[0] = 1;
		memo[1] = 1;
		for(int i = 2;i <= n;i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
		return memo[n];
	}

	// 动态规划优化，时间O(n),空间O(1)
	public static int climb4(int n) {
		if (n <= 1) {
			return n;
		}
		int pre = 1; int cur = 1;
		for(int i = 2;i<= n;i++) {
			int tem = cur;
			cur = pre + cur;
			pre = tem;
		}
		return cur;
	}
}
