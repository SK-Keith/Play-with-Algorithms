package com.keith.sort;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/11/14 0014 16:00
 */
public class QuickSort {

    public static Integer partion(Integer[] array, Integer l, Integer r) {
        Integer v = array[l];
        Integer j = l;
        for(Integer i = l+1;i<=r;i++) {
            if (array[i] < v) {
                j++;
                swap(array, i, j);
            }
        }
        swap(array, l, j);
        return j;
    }

    public static void swap(Integer[] array, Integer i, Integer j) {
        Integer temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(Integer[] array) {
        Integer length = array.length;
        sort(array, 0, length - 1);
    }

    public static void sort(Integer[] array, Integer l, Integer r) {
        if(l >= r) {
            return;
        }
        Integer partion = partion(array, l, r);
        sort(array, l, partion - 1);
        sort(array, partion + 1, r);
    }



}
