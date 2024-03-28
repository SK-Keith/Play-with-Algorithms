package shuangzhizhen;

import utils.PrintUtils;

/**
 * @author MX.Y
 * @DATE 2022-09-24 11:26
 */
public class YiDongLing2 {

    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while(fast < nums.length) {
            if(nums[fast] != 0) {
                change(nums, fast, slow);
                slow++;
            }
            fast++;
        }
    }

    private void change(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 3, 0, 4};
        YiDongLing2 y = new YiDongLing2();
        y.moveZeroes(nums);
        PrintUtils.printArray(nums);
    }
}
