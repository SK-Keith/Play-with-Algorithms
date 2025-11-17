package kgyy.com.keith.dongtai;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/5 0005 13:37
 */
public class Jump3 {

    public static int jump(int[] nums) {
        int farest = 0;
        int end = 0;
        int jumps = 0;
        for(int i=0;i<nums.length-1;i++) {
            farest = Math.max(i+nums[i], farest);
            if (i == end) {
                end = farest;
                jumps++;
                if (end > nums.length - 1) {
                    break;
                }
            }
        }
        return jumps;
    }

    public static boolean canJump(int[] nums) {
        int rightmost = 0;
        int end = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(i + nums[i], rightmost);
                if (rightmost > nums.length) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * [2,3，1，1,4]
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        int jump = jump(nums);
        System.out.println(jump);
    }
}
