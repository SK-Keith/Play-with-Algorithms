package kgyy.com.keith.hashDemo;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列（时间复杂度On，使用hash方法,空间复杂度小点，则使用排序解法）
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
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
                // 20251124 这个定义条件放在了外面，里面更好
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
