package kgyy.com.keith.dongtai;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/16 0016 14:35
 */
public class Jump20241216 {

    public static int jump(int[] nums) {
        int end = 0;
        int jump = 0;
        int farest = 0;

        for (int i = 0 ;i < nums.length - 1;i++) {
            farest = Math.max(farest, i + nums[i]);
            if (i == end) {
                end = farest;
                jump ++;
                if (end > nums.length - 1) {
                    break;
                }
            }
        }
        return jump;
    }

    public static boolean canjump(int[] nums) {
        int rightmost = 0;
        for(int i = 0;i<nums.length;i++) {
            if (i <= rightmost) {
                rightmost = Math.max(i + nums[i], rightmost);
                if (rightmost >= nums.length -1) {
                    return true;
                }
            }
        }
        return false;
    }
}
