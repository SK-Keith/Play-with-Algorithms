package kgyy.com.keith.digui;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/01/2 0002 13:19
 */
public class CLimb20250102 {


    public int climb(int num) {
        if (num == 1 || num == 2) {
            return num;
        }
        return climb(num - 1) + climb(num - 2);
    }

    public static int[] nums;
    public static int climb2(int num) {
        nums = new int[num + 1];
        return climb2Step(num, nums);
    }

    public static int climb2Step(int n, int[] nums) {
        // todo ymx
        return 1;
    }

    public static int climb3(int n) {
        int[] nums = new int[n + 1];
        if (n <= 2) {
            nums[n] = n;
            return n;
        }

        for (int i = 3;i <= n;i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums[n];
    }



}
