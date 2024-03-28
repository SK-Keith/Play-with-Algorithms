package utils;

import java.util.Arrays;
import java.util.List;

/**
 * @author MX.Y
 * @DATE 2022-09-24 10:48
 */
public class PrintUtils {

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }

    public static void printArray(char[] chars) {
        System.out.println(Arrays.toString(chars));
    }

    public static void printListList(List<List<Integer>> arrs) {
        int num = 1;
        for (List<Integer> arr : arrs) {
            System.out.print("行号：" + num + ":\t");
            for (Integer i : arr) {
                System.out.print(+ i + "   ");
            }
            num++;
            System.out.println();
        }
    }

    public static void printArray(int[][] nums) {
        for (int[] num : nums) {
            for (int n : num) {
                System.out.print(n + "\t");
            }
            System.out.println();
        }

    }
}
