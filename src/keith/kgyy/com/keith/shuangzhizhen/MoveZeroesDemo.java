package kgyy.com.keith.shuangzhizhen;

import java.util.Arrays;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/11/21 0021 11:37
 */
public class MoveZeroesDemo {
    public static void main(String[] args) {
        MoveZeroes20251124 solution = new MoveZeroes20251124();

        // 测试用例1：标准情况
        int[] nums1 = {0, 1, 0, 3, 12};
        System.out.println("输入: " + Arrays.toString(nums1));
        solution.moveZeroes(nums1);
        System.out.println("输出: " + Arrays.toString(nums1));
        System.out.println();

        // 测试用例2：全是0
        int[] nums2 = {0, 0, 0, 0};
        System.out.println("输入: " + Arrays.toString(nums2));
        solution.moveZeroes(nums2);
        System.out.println("输出: " + Arrays.toString(nums2));
        System.out.println();

        // 测试用例3：没有0
        int[] nums3 = {1, 2, 3, 4};
        System.out.println("输入: " + Arrays.toString(nums3));
        solution.moveZeroes(nums3);
        System.out.println("输出: " + Arrays.toString(nums3));
        System.out.println();

        // 测试用例4：0在开头和结尾
        int[] nums4 = {0, 1, 2, 3, 0};
        System.out.println("输入: " + Arrays.toString(nums4));
        solution.moveZeroes(nums4);
        System.out.println("输出: " + Arrays.toString(nums4));
        System.out.println();

        // 测试用例5：单个元素
        int[] nums5 = {0};
        System.out.println("输入: " + Arrays.toString(nums5));
        solution.moveZeroes(nums5);
        System.out.println("输出: " + Arrays.toString(nums5));
        System.out.println();

        // 测试用例6：单个非零元素
        int[] nums6 = {5};
        System.out.println("输入: " + Arrays.toString(nums6));
        solution.moveZeroes(nums6);
        System.out.println("输出: " + Arrays.toString(nums6));
    }
}
