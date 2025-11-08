package com.keith.search;

/**
 * 查找元素的方法
 * 1. 二分法（使用于有序场景、时间复杂度O(log n)）
 * 2. 哈希法（适用于无序场景，空间复杂度O(n)）
 * 3. 线性法（适用于无序数据，简单直观但效率较低）
 * 4. 树结构（（如二叉搜索树）适用于动态数据集，支持高效的查找、插入和删除）
 *
 * @author yaomianxian
 * @date 2024/04/7 0007 14:44
 */
public class Search {
    /**
     * 使用二分查找，每次查找都把区间缩小一半
     * 时间复杂度为O(log n)，空间复杂度为O(1)
     * @param nums
     * @param target
     * @return
     */
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
