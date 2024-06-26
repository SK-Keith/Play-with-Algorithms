package sorting;

import utils.SortTestHelper;

/**
 * @author MX.Y
 * @DATE 2021/8/28 11:07
 * @qq 2690399241
 */
public class QuickSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        sort(arr, 0,  n -1);
    }

    // 递归使用快速排序， 对arr[l..r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {
        // 对于小规模的数组，还是推荐使用插入排序，因为可以达到时间复杂度为O（n）的高效
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p-1);
        sort(arr, p+1, r);
    }

    // 对arr[l..r]进行partition操作
    // 返回p, 使得arr[l..p+1] < arr[p];arr[p+1..r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {

        // 随机在arr[l..r]的范围内，选择一个数值座位定点pivot
        swap(arr, l, (int)(Math.random()*(r-l+1)) + 1);

        Comparable v = arr[l];

        // arr[l+1..j] < v;arr[j+1..i] > v
        int j = l;
        for(int i=l + 1;i<=r;i++) {
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, j, i);
            }
        }

        return j;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
        SortTestHelper.testSort("sorting.QuickSort", arr);
    }
}
