package lettcode;

/**
 * https://leetcode-cn.com/problems/deep-dark-fraction/
 * @author MX.Y
 * @DATE 2021/9/5 16:49
 * @qq 2690399241
 */
public class j090501 {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 6, 3};
        int[] fraction = fraction(nums);
        for (int i = 0; i < fraction.length; i++) {
            System.out.println(fraction[i]);
        }
    }

    public static int[] fraction(int[] nums) {
        int length = nums.length;
        int m = nums[length -1];
        int n = 1;
        for (int i = length -2;i >= 0; i--) {
            int tmp = m;
            m = m * nums[i] + n;//19*5+3=95+3=98
            n = tmp;
        }
        return new int[]{m, n};
    }
}
