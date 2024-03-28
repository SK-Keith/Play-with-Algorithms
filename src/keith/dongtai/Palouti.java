package dongtai;

/**
 * @author MX.Y
 * @DATE 2021/12/21 20:59
 */
public class Palouti {

    public static void main(String[] args) {
        int n = 5;
        Palouti p = new Palouti();
        int i = p.climbStairs(n);
        System.out.println(i);
    }

    private int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            q = p;
            p = r;
            r = p + q;
        }
        return r;
    }

//    private int climbStairs(int n) {
//        /**
//         * 1 1
//         * 2 2
//         * 3 3
//         * 4 5
//         * 5 8
//         */
//        if (n == 1 || n == 2) {
//            return n;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }
}
