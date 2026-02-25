package kgyy.com.keith.dongtai;

/**
 * @author MX.Y
 * @DATE 2026/2/25 14:58
 */
public class CanJump20260225{

    public static boolean canjumpError(int[] nums) {
        int n = nums.length;
        int farmost = 0;

        for(int i = 0; i < n; i++) {
            // ERROR
            if (farmost < i) {
                farmost = Math.max(i + nums[i], farmost);
                if (farmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canjump(int[] nums) {
        int n = nums.length;
        int farmost = 0;

        for(int i = 0; i < n; i++) {
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
