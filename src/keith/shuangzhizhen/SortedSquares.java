package shuangzhizhen;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/squares-of-a-sorted-array/submissions/
 * @author MX.Y
 * @DATE 2022-12-21 18:20
 */
public class SortedSquares {

    public static void main(String[] args) {
        int[] nums = new int[]{-7,-3,2,3,11};
        SortedSquares s = new SortedSquares();
        int[] ints = s.sortedSquares(nums);
        PrintUtils.printArray(ints);

    }

    public int[] sortedSquares(int[] nums) {
        int size = nums.length -1;
        // 判断正负的平方是根据最左和最右的平方来进行判断的，逐渐移动左或右节点
        // 然后使用数组的最大位开始逐渐变小来赋值
        int left = 0, right = size;
        int[] result = new int[nums.length];
        // 等于0是指最后一个节点，即size = 0  size >= 0  left <= right
        while(size >= 0) {
            int ll = nums[left] * nums[left];
            int rr = nums[right] * nums[right];

            if (ll <= rr) {
                result[size] = rr;
                right--;
            } else {
                result[size] = ll;
                left++;
            }
            size--;
        }
        return result;
    }
}
