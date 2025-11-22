package kgyy.com.keith.shuangzhizhen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-100-liked
 *
 * @author yaomianxian
 * @date 2025/11/22 0022 10:44
 */
public class ThreeSum {

    /**
     * 先对数组排序（O(n log n)）
     * 遍历数组，固定第一个数 nums[i]
     * 然后用双指针在 i后面的部分寻找两个数，使得三数之和为 0
     * 注意跳过重复元素以避免重复三元组
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 3) return result;

        Arrays.sort(nums);
        // 注意是从0开始
        for(int i =0;i<n-2;i++) {
            // 注意是i > 0 时，避免越界
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }

            int left = i + 1;
            int right = n - 1;

            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // 写法Arrays.asList()
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        // 注意是--，不是++
                        right--;
                    }

                    left++;
                    // 注意是--，不是++
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    // 注意是--，不是++
                    right--;
                }
            }
        }
        return result;
    }
}
