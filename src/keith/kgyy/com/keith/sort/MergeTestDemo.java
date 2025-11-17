package kgyy.com.keith.sort;

import java.util.Arrays;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/24 0024 15:04
 */
public class MergeTestDemo {

    public static void main(String[] args) {
        Integer[] arr = {5, 2, 9, 1, 5, 6};
        MergeSort20241224.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        Integer[] emptyArr = {};
        MergeSort20241224.sort(emptyArr, 0, emptyArr.length - 1);
        System.out.println(Arrays.toString(emptyArr));

        Integer[] singleArr = {42};
        MergeSort20241224.sort(singleArr, 0, singleArr.length - 1);
        System.out.println(Arrays.toString(singleArr));
    }
}
