package kgyy.com.keith.shuangzhizhen;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/11/22 0022 10:57
 */
public class ThreeSumDemo {
    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums1));
        // 输出：[[-1, -1, 2], [-1, 0, 1]]

        int[] nums2 = {0, 1, 1};
        System.out.println(solution.threeSum(nums2));
        // 输出：[]

        int[] nums3 = {0, 0, 0};
        System.out.println(solution.threeSum(nums3));
        // 输出：[[0, 0, 0]]
    }
}
