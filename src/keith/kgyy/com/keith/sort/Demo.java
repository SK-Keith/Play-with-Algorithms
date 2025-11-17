package kgyy.com.keith.sort;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/07/18 0018 15:33
 */
public class Demo {

    public static void main(String[] args) {

        // 测试Integer
//        Integer[] a = {10, 9, 8, 7,  5, 6, 4, 3, 2, 1};
//        SelectionSort.sort(a);
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i]);
//            System.out.print(' ');
//        }
//        System.out.println();
//        Integer[] a1 = {10, 9, 8, 7,  5, 6, 4, 3, 2, 1};
//        MergeSort.sort(a1);
//        for (int i = 0; i < a1.length; i++) {
//            System.out.print(a1[i]);
//            System.out.print(' ');
//        }

        Integer[] a2 = {10, 9, 8, 7,  5, 6, 4, 3, 2, 1};
        QuickSort.sort(a2);
        for (int i = 0; i < a2.length; i++) {
            System.out.print(a2[i]);
            System.out.print(' ');
        }

    }


}
