package kgyy.com.keith.sort;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/07/18 0018 15:05
 */
public class SelectionSort {

    public static void sort(Comparable[] arrays) {
        int length = arrays.length;
        for (int i=0;i<length;i++) {
            int minIndex = i;
            for (int j = i;j<length;j++) {
                if (arrays[minIndex].compareTo(arrays[j]) > 0) {
                    minIndex = j;
                }
            }
            swap(arrays, minIndex, i);
        }
    }

    private static void swap(Comparable[] arrays, int minIndex, int i) {
        Comparable temp = arrays[minIndex];
        arrays[minIndex] = arrays[i];
        arrays[i] = temp;
    }

}
