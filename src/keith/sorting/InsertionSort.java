package sorting;

/**
 * 插入排序
 * @author MX.Y
 * @DATE 2021/8/28 10:40
 * @qq 2690399241
 */
public class InsertionSort {

    // 对arr[l..r]的区间使用插入排序
    public static void sort(Comparable[] arr, int l, int r) {
        /**
         * for (int i = 1;i <= length; i++) {
         *      int e = arr[i];
         *      for (int j = i; j > 1 && arr[j-1] > e; j--) {
         *          arr[j] = arr[j - 1];
         *      }
         *      arr[j] = e;
         * }
         */
        /**
         * 1.对于插入排序而言，第0个元素不用考虑，因为本身就是有序的，所以从1开始
         * 2.第二层循环的目的就是找到前面集合中的合适位置
         * 3.第二层停止的条件是j > 0，也就是最后一个比较是拿当前元素跟第一个元素比较，所以j > 0
         */
        for (int i = l + 1; i <= r; i++) {
            // 寻找元素arr[i]合适的插入位置
            Comparable e = arr[i];
            // j 保存元素 e 应该要插入的位置
            int j = i;
            for (; j > 1 && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }
}
