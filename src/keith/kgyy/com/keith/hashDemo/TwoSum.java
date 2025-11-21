package kgyy.com.keith.hashDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * @author yaomianxian
 * @date 2025/11/21 0021 9:38
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0;i<nums.length;i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                return new int[]{map.get(result), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

}
