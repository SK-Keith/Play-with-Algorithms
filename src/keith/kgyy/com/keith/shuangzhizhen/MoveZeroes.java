package kgyy.com.keith.shuangzhizhen;

/**
 * 移动零
 * https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 *
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
