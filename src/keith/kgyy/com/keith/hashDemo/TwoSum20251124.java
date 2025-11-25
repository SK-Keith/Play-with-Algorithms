package kgyy.com.keith.hashDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/11/24 0024 11:15
 */
public class TwoSum20251124 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{i, map.get(result)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
