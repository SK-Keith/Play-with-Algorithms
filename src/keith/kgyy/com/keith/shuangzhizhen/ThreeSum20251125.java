package kgyy.com.keith.shuangzhizhen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/11/25 0025 13:45
 */
public class ThreeSum20251125 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[i - 1]) {
                int target = 0 - nums[i];
                int left = i, right = length - i;
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                } else if (sum < target) {
                    left++;
                } else {
                    right++;
                }
            }
        }
        return result;
    }
}
