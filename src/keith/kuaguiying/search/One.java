package com.keith.search;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/04/9 0009 13:35
 */
public class One {

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int searchLeftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < target) {
                left = mid +1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        if (left <= 0 || left > nums.length - 1) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    public static int searchRightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < target) {
                left = mid +1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right <= 0 || right > nums.length - 1) {
            return -1;
        }
        return nums[right] == target ? right : -1;
    }
}
