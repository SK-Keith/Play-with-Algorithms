package shuangzhizhen;

/**
 * @author MX.Y
 * @DATE 2022-05-26 16:08
 */
public class MoveZero {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        MoveZero m = new MoveZero();
        m.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + "->");
        }
    }

    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        int index = 0;
        while(fast < nums.length) {
            if (nums[index] != 0) {
                nums[slow++] = nums[index];
            }
            index++;
            fast++;
        }
        fillZero(nums, slow);
    }

    private void fillZero(int[] nums, int slow) {
        for (int i = slow;i < nums.length; i++) {
            nums[i] = 0;
        }
    }


}
