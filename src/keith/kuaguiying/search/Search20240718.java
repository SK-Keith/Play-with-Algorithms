package com.keith.search;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/07/18 0018 14:17
 */
public class Search20240718 {

    public static int search(int[] arrays, int target) {
        int size = arrays.length;
        int left = 0, right = size - 1;
        while(left <= right) {
            int mid = left + (right - left) >> 1;
            if (arrays[mid] < target) {
                left = mid + 1;
            } else if (arrays[mid] > target) {
                right = mid - 1;
            } else if (arrays[mid] == target) {
                return mid;
            }
        }
        return -1;
    }
}
