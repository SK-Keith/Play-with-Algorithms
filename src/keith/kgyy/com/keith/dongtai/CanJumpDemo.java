package kgyy.com.keith.dongtai;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/16 0016 14:55
 */
public class CanJumpDemo {

    public static void main(String[] args) {
        // 测试用例 1: 可以跳跃到最后一个位置
        int[] testCase1 = {2, 3, 1, 1, 4};
        System.out.println("Test case 1: " + CanJump20241225.canjump(testCase1)); // Expected output: true

        // 测试用例 2: 无法跳跃到最后一个位置
        int[] testCase2 = {3, 2, 1, 0, 4};
        System.out.println("Test case 2: " + CanJump20241225.canjump(testCase2)); // Expected output: false

        // 测试用例 3: 只有一个元素，已到达最后一个位置
        int[] testCase3 = {0};
        System.out.println("Test case 3: " + CanJump20241225.canjump(testCase3)); // Expected output: true

        // 测试用例 4: 起始位置就不能跳跃，无法到达
        int[] testCase4 = {0, 2, 3};
        System.out.println("Test case 4: " + CanJump20241225.canjump(testCase4)); // Expected output: false

        // 测试用例 5: 长度为 2，可以直接跳跃到终点
        int[] testCase5 = {1, 1};
        System.out.println("Test case 5: " + CanJump20241225.canjump(testCase5)); // Expected output: true

        // 测试用例 6: 较长的数组，可以跳跃到最后
        int[] testCase6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println("Test case 6: " + CanJump20241225.canjump(testCase6)); // Expected output: true
    }

}
