package kgyy.com.keith.dongtai;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false
 *
 * @author yaomianxian
 * @date 2024/12/25 0025 14:05
 */
public class CanJump20241225 {
    /**
     * 贪心算法，每次跳最远的距离，直至到达最远距离的边缘
     * @param nums
     * @return
     */
    public static boolean canjumpError(int[] nums) {
        int farmost = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++) {
            // error1
            if (i >= farmost) {
                farmost = Math.max(i + nums[i], farmost);
                // error2
                if (farmost >= n) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canjump(int[] nums) {
        int farmost = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++) {
            if (i <= farmost) {
                farmost = Math.max(i + nums[i], farmost);
                if (farmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
