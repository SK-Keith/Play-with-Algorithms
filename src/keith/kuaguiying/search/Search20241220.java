package com.keith.search;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/20 0020 14:03
 */
public class Search20241220 {

    public static int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        while (left < right) {
            int mid = (left + right)/2;
            if (nums[mid] > target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
