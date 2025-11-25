package kgyy.com.keith.shuangzhizhen;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/11/22 0022 9:47
 */
public class MaxAreaDemo {
    public static void main(String[] args) {
        MaxArea20251124 solution = new MaxArea20251124();
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution.maxArea(height1)); // 输出: 49

        int[] height2 = {1, 1};
        System.out.println(solution.maxArea(height2)); // 输出: 1

        int[] height3 = {4, 3, 2, 1, 4};
        System.out.println(solution.maxArea(height3)); // 输出: 16
    }
}
