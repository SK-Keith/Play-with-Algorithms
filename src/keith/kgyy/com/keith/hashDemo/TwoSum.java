package kgyy.com.keith.hashDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 *
 * 你可以按任意顺序返回答案。
 * @author yaomianxian
 * @date 2025/11/21 0021 9:38
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0;i<nums.length;i++) {
            int result = target - nums[i];
            if (map.containsKey(result)) {
                // 注意返回的数组顺序
                return new int[]{map.get(result), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

}
