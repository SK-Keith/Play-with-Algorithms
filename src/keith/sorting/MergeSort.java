package sorting;

import utils.SortTestHelper;

import java.util.Arrays;

/**
 * 递归
 * 归并排序、快速排序、二叉树的遍历、求高度、回溯八皇后、背包问题、DFS的递归
 * 二分法排序
 *
 * @author MX.Y
 * @DATE 2021/8/28 9:44
 * @qq 2690399241
 */
public class MergeSort {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        // 对于小规模的数组，使用插入排序
        if (r - l < 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = l + (r -l)/ 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        // 对于arr[mid] <= arr[mid+1]的情况，不进行merge
        // 对于近乎有序的数组非常有效，但是对于一般情况，有一定的性能损耗
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    // 将arr[l..mid] 和arr[mid+1..r]这两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的的起始索引位置l, j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) { // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }

    }

    public static void main(String[] args) throws Exception {
//        Thread.sleep(10*6 *1000);
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
        SortTestHelper.testSort("sorting.MergeSort", arr);

        return;

    }
}
