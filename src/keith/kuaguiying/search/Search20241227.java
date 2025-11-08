package com.keith.search;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/27 0027 14:11
 */
public class Search20241227 {

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) >>1;
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

    public static int searchInLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid = 1;
            } else {
                right = mid - 1;
            }
        }
        if (left < 0 || left > nums.length - 1) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }
}
