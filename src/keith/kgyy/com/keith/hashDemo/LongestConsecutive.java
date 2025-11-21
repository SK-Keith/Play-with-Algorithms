package kgyy.com.keith.hashDemo;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列（时间复杂度On，使用hash方法,空间复杂度小点，则使用排序解法）
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * @author yaomianxian
 * @date 2025/11/21 0021 11:10
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                // 20251121,不是num+1,是currentNum + 1
                while(set.contains(currentNum + 1)) {
                    // 20251121,不是currentNum=num+1,是currentNum++
                    currentNum++;
                    currentLength++;
                }
                longest = Math.max(longest, currentLength);
            }

        }
        return longest;
    }

}
