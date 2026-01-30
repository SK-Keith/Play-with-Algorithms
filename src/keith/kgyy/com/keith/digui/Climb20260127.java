package kgyy.com.keith.digui;

public class Climb20260127 {

    public static int climb(int n) {
    	if(n == 1) {
    		return 1;
    	}
    	if (n == 2) { 
    		return 2;
    	}
    	return climb(n - 1) + climb(n -2);
	}

	public static Integer[] memo;

	public static int climb2(int n) {	
		memo = new Integer[n+1];
		return climb2Memo(n);
	}

	public static int climb2Memo(int n) {
		if (n <= 2) {
			return n;
		}
		if (memo[n] != null && memo[n] != 0) {
			return memo[n];
		}
		memo[n] = climb2Memo(n - 1) + climb2Memo(n - 2);
		return memo[n];
	}

	public static int climb3(int n) {
		if (n <= 2) {
			return n;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i<=n;i++) {
			dp[i] = dp[i - 1] + dp[i -2];
		}
		return dp[n];
	}

	public static int climb4(int n) {
		if (n <= 2) {
			return n;
		}
		int prev1 = 1, prev2 = 1;
		for(int i = 2;i <= n;i++) {
			int cur = prev1 + prev2;
			prev2 = prev1;
			prev1 = cur;
		}		
		return prev1;

	}
}