package kgyy.com.keith.digui;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/08/7 0007 19:16
 */
public class Climb2 {

    public static Integer climb(int n) {
        if (n <= 2) {
            return n;
        }

        return climb(n -1) + climb(n -2);
    }

    public static Integer[] memo = null;

    public static Integer climb2(int n) {
        memo = new Integer[n + 1];
        return climb2ByMemo(n);
    }

    public static Integer climb2ByMemo(int n) {
        if (n <= 2) {
            return n;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        return climb2ByMemo(n - 1) + climb2ByMemo(n -2);
    }
}
