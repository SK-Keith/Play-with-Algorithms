package kgyy.com.keith.digui;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/01/8 0008 13:23
 */
public class Climb20250108 {

    public static int climb(int num) {
        // 递归
        if (num == 1 || num == 2) {
            return num;
        }
        return climb(num - 1) + climb(num - 2);
    }

    public static int climb2(int num) {
        // 递归优化，使用数组存储子问题的解，避免重复计算
        int[] nums = new int[num + 1];
        return climb2Step(num, nums);
    }

    public static int climb2Step(int n, int[] nums) {
        if (n == 1 || n == 2) {
            nums[n] = n;
            return n;
        }
        if (nums[n] != 0) {
            return nums[n];
        }
        nums[n] = climb2Step(n - 1, nums) + climb2Step(n - 2, nums);
        return nums[n];
    }

    public static int climb3(int n) {
        int[] nums = new int[n + 1];
        if (n <= 2) {
            return n;
        }
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3;i <= n;i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums[n];
    }

    public static int climb4(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3;i <= n;i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }
}
