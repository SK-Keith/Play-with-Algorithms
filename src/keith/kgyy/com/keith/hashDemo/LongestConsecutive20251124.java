package kgyy.com.keith.hashDemo;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/11/24 0024 14:40
 */
public class LongestConsecutive20251124 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            sets.add(num);
        }
        int maxSize = 0;
        for (Integer num : sets) {
            int currentNum = num;
            int currentSize = 1;
            if (!sets.contains(num - 1)) {
                while(sets.contains(currentNum + 1)) {
                    currentSize += 1;
                    currentNum += 1;
                }
            }
            maxSize = Math.max(maxSize, currentSize);
        }
        return maxSize;
    }
}
