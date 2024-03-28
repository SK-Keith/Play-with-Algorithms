package shuangzhizhen;

/**
 * @author MX.Y
 * @DATE 2023-01-05 17:32
 */
public class MoveZero2 {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while(fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        if (slow < fast) {
            for(int i = slow; i < fast;i++) {
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        MoveZero2 m = new MoveZero2();
        m.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + "->");
        }
    }
}
