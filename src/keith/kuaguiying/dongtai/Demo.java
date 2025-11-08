package com.keith.dongtai;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/16 0016 14:38
 */
public class Demo {

    public static void main(String[] args) {
        Jump20250310 solution = new Jump20250310();

        // 测试用例 1: 可以跳跃到最后一个位置
        int[] testCase1 = {2, 3, 1, 1, 4};
        System.out.println("Test case 1 (DP): " + solution.jumpDP(testCase1)); // Expected output: 2
        System.out.println("Test case 1 (Greedy): " + solution.jumpGreedy(testCase1)); // Expected output: 2

        // 测试用例 2: 无法跳跃到最后一个位置
        int[] testCase2 = {3, 2, 1, 0, 4};
        System.out.println("Test case 2 (DP): " + solution.jumpDP(testCase2)); // Expected output: 2147483647,Integer.MAX_VALUE
        System.out.println("Test case 2 (Greedy): " + solution.jumpGreedy(testCase2)); // Expected output: 2147483647

        // 测试用例 3: 只有一个元素，已到达最后一个位置
        int[] testCase3 = {0};
        System.out.println("Test case 3 (DP): " + solution.jumpDP(testCase3)); // Expected output: 0
        System.out.println("Test case 3 (Greedy): " + solution.jumpGreedy(testCase3)); // Expected output: 0

        // 测试用例 4: 起始位置就不能跳跃，无法到达
        int[] testCase4 = {0, 2, 3};
        System.out.println("Test case 4 (DP): " + solution.jumpDP(testCase4)); // Expected output: Integer.MAX_VALUE (or some large number)
        System.out.println("Test case 4 (Greedy): " + solution.jumpGreedy(testCase4)); // Expected output: Integer.MAX_VALUE (or some large number)

        // 测试用例 5: 长度为 2，可以直接跳跃到终点
        int[] testCase5 = {1, 1};
        System.out.println("Test case 5 (DP): " + solution.jumpDP(testCase5)); // Expected output: 1
        System.out.println("Test case 5 (Greedy): " + solution.jumpGreedy(testCase5)); // Expected output: 1

        // 测试用例 6: 较长的数组，可以跳跃到最后
        int[] testCase6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println("Test case 6 (DP): " + solution.jumpDP(testCase6)); // Expected output: 4
        System.out.println("Test case 6 (Greedy): " + solution.jumpGreedy(testCase6)); // Expected output: 4
    }
}
