package shuangzhizhen;

/**
 * 将零移到最后一位
 *
 * https://leetcode-cn.com/problems/move-zeroes/
 * @author MX.Y
 * @DATE 2022-03-12 9:45
 */
public class YiDonglign {

//    public void moveZeroes(int[] nums) {
//        int length = nums.length;
//        int left = 0, right = length - 1;
//        while(left < length -1) {
//            if (nums[left] == 0) {
//                swap(nums, left, right);
//                right--;
//            }
//            left++;
//        }
//    }

    public void moveZeroes(int[] nums) {
        // 双指针法，定义两个指向头部的指针，一个指针每次遍历都加一，另一个指针满足条件时就加一
        int n = nums.length, left = 0, right = 0;
        int result[] = new int[2];
        while (right < n) {
            if (nums[right] != 0) {
                if (left != right) {
                    swap(nums, left, right);
                }
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 0, 3, 0, 4};
        YiDonglign l = new YiDonglign();
        l.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }
}
