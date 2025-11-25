package kgyy.com.keith.shuangzhizhen;

/**
 * 移动零
 * https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作
 * @author yaomianxian
 * @date 2025/11/21 0021 11:25
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for(int fast = 0;fast<nums.length;fast++) {
            if (nums[fast]!=0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
        }
    }
}
