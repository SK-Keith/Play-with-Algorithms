package kgyy.com.keith.hashDemo;

import java.util.Arrays;
import java.util.List;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/11/21 0021 10:37
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println("---------------TwoSum-------");
        int[] numbers = {2, 7, 11, 15, 18, 22};  // 已排序
        int target = 26;
        TwoSum20251124 twoSum = new TwoSum20251124();
        int[] ints = twoSum.twoSum(numbers, target);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println();
        System.out.println("---------------GroupAnagrams-------");
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams20251124 groupAnagrams = new GroupAnagrams20251124();
        List<List<String>> lists = groupAnagrams.groupAnagrams(strs);
        System.out.println("输入: " + Arrays.toString(strs));
        System.out.println("输出: " + lists);
        System.out.println();

        System.out.println();
        System.out.println("---------------LongestConsecutive-------");
        LongestConsecutive20251124 solution = new LongestConsecutive20251124();

        // 测试用例1：标准例子
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        testCase(solution, nums1, 4, "标准例子");

        // 测试用例2：包含重复数字
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        testCase(solution, nums2, 9, "包含重复数字");

        // 测试用例3：空数组
        int[] nums3 = {};
        testCase(solution, nums3, 0, "空数组");

        // 测试用例4：单个数字
        int[] nums4 = {5};
        testCase(solution, nums4, 1, "单个数字");

        // 测试用例5：多个独立序列
        int[] nums5 = {1, 3, 5, 2, 4, 10, 12, 11};
        testCase(solution, nums5, 5, "多个独立序列");

        // 测试用例6：所有数字都不连续
        int[] nums6 = {1, 5, 9, 13};
        testCase(solution, nums6, 1, "所有数字都不连续");

        // 测试用例7：负数测试
        int[] nums7 = {-1, -3, -2, 0, 1, 2};
        testCase(solution, nums7, 4, "包含负数");

        // 测试用例8：大数字
        int[] nums8 = {1000000, 999999, 1000001};
        testCase(solution, nums8, 3, "大数字");



    }

    public static void testCase(LongestConsecutive20251124 solution, int[] nums, int expected, String description) {
        int result1 = solution.longestConsecutive(nums);
        int result2 = solution.longestConsecutive(nums);

        System.out.println("=== " + description + " ===");
        System.out.println("输入: " + Arrays.toString(nums));
        System.out.println("HashSet解法结果: " + result1);
        System.out.println("排序解法结果: " + result2);
        System.out.println("期望结果: " + expected);
        System.out.println("HashSet解法: " + (result1 == expected ? "✓ 正确" : "✗ 错误"));
        System.out.println("排序解法: " + (result2 == expected ? "✓ 正确" : "✗ 错误"));
        System.out.println();
    }
}
