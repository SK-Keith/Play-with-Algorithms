package kgyy.com.keith.sort;

import java.util.Arrays;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/24 0024 14:02
 */
public class MergeSort20241224 {

    public static void sort(Comparable[] nums) {
        int length = nums.length;
        sort(nums, 0, length - 1);
    }

    public static void sort(Comparable[] nums, int l, int r) {
        // 要用 l >= r 在只有一个元素的数组中才可以被处理
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(nums, l, mid);
        sort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private static void merge(Comparable[] nums, int l, int mid, int r) {
        Comparable[] copy = Arrays.copyOfRange(nums, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; i < copy.length; i++) {
            if (i > mid) {
                nums[k] = copy[j -l];
                j++;
            } else if (j > r) {
                nums[k] = copy[i -l];
                i++;
            } else if (copy[i - l].compareTo(copy[j - l]) > 0) {
                nums[k] = copy[j - l];
                j++;
            } else if (copy[i-l].compareTo(copy[j-l]) <= 0) {
                nums[k] = copy[i - l];
                i++;
            }
        }
    }
}
