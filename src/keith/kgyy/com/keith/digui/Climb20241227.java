package kgyy.com.keith.digui;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/27 0027 13:34
 */
public class Climb20241227 {

    public static int climb(int n) {
        if (n <= 2) {
            return n;
        }
        return climb(n - 1) + climb(n - 2);
    }

    public static int[] memo;
    public static int climb2(int n) {
        memo = new int[n + 1];
        return climb2ByMemo(n, memo);
    }

    private static int climb2ByMemo(int n, int[] memo) {
        if (n <= 2) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        return climb2ByMemo(n - 1, memo) + climb2ByMemo(n - 2, memo);
    }


    public static int climb3Error(int n) {
        int[] nums = new int[n + 1];
        if (n <= 2) {
            return n;
        }
        for(int i = 3;i<= n;i++) {
            nums[n] = nums[n-1] + nums[n - 2];
        }
        return nums[n];
    }

    public static int climb3(int n) {
        int[] nums = new int[n + 1];
        if (n <= 2) {
            return n;
        }
        nums[1] = 1;
        nums[2] = 2;
        for(int i = 3;i<= n;i++) {
            nums[i] = nums[i-1] + nums[i - 2];
        }
        return nums[n];
    }

    public static int climb4(int n) {
        if (n <=2) {
            return n;
        }
        int prev = 1; int cur = 2;
        for(int i = 3;i<=n;i++) {
            int temp = cur;
            cur = prev + cur;
            prev = temp;
        }
        return cur;
    }
}
