package shuangzhizhen;

import utils.PrintUtils;

/**
 * https://leetcode.cn/problems/rotate-array/solution/
 * @author MX.Y
 * @DATE 2022-09-24 10:43
 */
public class Rotate2 {

    public void rotate(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);

        reverse(nums, 0, k - 1);

        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int length) {
        while(i < length) {
            int temp = nums[i];
            nums[i] = nums[length];
            nums[length] = temp;
            i++;
            length --;
        }
    }

    public static void main(String[] args) {
        Rotate2 r = new Rotate2();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        r.rotate(nums, 5);
        PrintUtils.printArray(nums);
    }
}
