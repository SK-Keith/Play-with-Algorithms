package com.keith.search;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/04/7 0007 14:44
 */
public class Search2 {

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
            int mid = left + (right - left) /2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        if (left < 0 || left > nums.length -1) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    public static int searchRightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) /2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right < 0 || right > nums.length -1) {
            return -1;
        }
        return nums[right] == target ? right : -1;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1,3,3,5,5,7};
        int target = 3;
//        int i = searchLeftBound(nums, target);
//        int i = search(nums, target);
        int i = searchRightBound(nums, target);
        System.out.println(i);
    }
}
