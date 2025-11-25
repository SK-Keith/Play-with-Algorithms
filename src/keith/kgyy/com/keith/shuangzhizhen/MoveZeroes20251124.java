package kgyy.com.keith.shuangzhizhen;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/11/24 0024 14:55
 */
public class MoveZeroes20251124 {

    public void moveZeroes(int[] nums) {
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}
