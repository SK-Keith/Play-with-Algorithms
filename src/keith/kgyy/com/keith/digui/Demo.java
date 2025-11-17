package kgyy.com.keith.digui;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/08/6 0006 20:24
 */
public class Demo {

//    public static void main(String[] args) {
//        int climb = Climb2.climb(5);
//        System.out.println("climb1:" + climb);
//
//        int climb2 = Climb2.climb2(4);
//        System.out.println("climb2:" + climb2);
//    }

    public static void main(String[] args) {
        int n = 5; // 举例，楼梯的级数为 5,result:8
        // 使用递归解法 Climb20250303  Climb20250115
        System.out.println("Number of ways to climb " + n + " stairs: " + Climb20250303.climb(n));
        // 递归优化，使用数组存储子问题的解，避免重复计算
        System.out.println("Number of ways to climb " + n + " stairs: " + Climb20250303.climb2(n));
        // 使用动态规划解法
        System.out.println("Number of ways to climb " + n + " stairs: " + Climb20250303.climb3(n));
        // 动态规划优化空间，省去计算过程的数组，直接返回结果
        System.out.println("Number of ways to climb " + n + " stairs: " + Climb20250303.climb4(n));
    }
}
