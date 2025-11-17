package kgyy.com.keith.digui;

public class Climb20250303 {
	public static int climb(int n) {
		if (n <= 2) {
			return n;
		}
		return climb(n - 1) + climb(n - 2);
	}

	public static Integer[] memo;


	public static int climb2(int n) {
		memo = new Integer[n + 1];
		return climb2ByMemo(n);
	}

	public static int climb2ByMemo(int n) {
		if (n <= 2) {
			return n;
		}
		if (memo[n] != null) {
			return memo[n];
		}
		return climb2ByMemo(n -1) + climb2ByMemo(n - 2);
	}

	public static int climb3(int n) {
		if (n <= 2) {
			return n;
		}
		int[] nums = new int[n + 1];
		nums[0] = 0;
		nums[1] = 1;
		nums[2] = 2;
		for(int i = 3;i<= n;i++) {
			nums[i] = nums[i - 1] + nums[i - 2];
		}
		return nums[n];
	}

	public static int climb4(int n) {
		if(n <= 2) {
			return n;
		}
		int pre = 1, next = 1;
		for(int i = 2;i <= n;i++) {
			int temp = next;
			next = pre + next;
			pre = temp;
		}
		return next;
	}
}
