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
public class ThreeSum202511252 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 3) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0;i < n-2;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 如果是第一个就大于0，就不需要再往后了
            if (nums[i] > 0) {
                break;
            }
            // i 后面第一个
            int left = i + 1;
            // 右指针为最右边的
            int right = n - 1;
            // 双指针用法
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return result;
    }
}
