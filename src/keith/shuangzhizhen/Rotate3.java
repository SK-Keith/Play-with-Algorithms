package shuangzhizhen;

import utils.PrintUtils;

/**
 * @author MX.Y
 * @DATE 2022-09-24 10:50
 */
public class Rotate3 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] nums2 = new int[n];
        for (int i = 0; i < k; k++) {
            nums2[(i + k) % n] = nums[i];
        }
        System.arraycopy(nums2, 0, nums, 0, n);
    }

    public static void main(String[] args) {
        Rotate2 r = new Rotate2();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        r.rotate(nums, 3);
        PrintUtils.printArray(nums);
    }
}
