package kgyy.com.keith.sort;

import java.util.Arrays;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/07/23 0023 10:51
 */
public class MergeSort {
    /**
     * 归并排序，时间复杂度为O(nlog N)、空间复杂度O(1)
     * 1. 首先将数组不断划分为更小的子数组，直到每个子数组只有一个元素或为空
     * 2. 然后递归地对每个子数组进行排序
     * 3. 最后将排好序的子数组，合并成一个有序的数组
     * @param arrays
     */
    public static void sort(Comparable[] arrays) {
        int length = arrays.length;
        sort(arrays, 0, length - 1);
    }

    public static void sort(Comparable[] arrays, int l, int r) {
        // 这就是归并排序中划分到最小子问题的体现
        if (l >= r) {
            return;
        }
        int mid = l + (r - l)/2;
        sort(arrays, l, mid);
        sort(arrays, mid+1, r);
        merge(arrays, l, mid, r);
    }


    private static void merge(Comparable[] arrays, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arrays, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l;k<=r;k++) {
            if (i > mid) {
                arrays[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arrays[k] = aux[i - l];
                i++;
            } else if (aux[i -l].compareTo(aux[j-l]) > 0) {
                arrays[k] = aux[j-l];
                j++;
            } else {
                arrays[k] = aux[i-l];
                i++;
            }
        }
    }

}
