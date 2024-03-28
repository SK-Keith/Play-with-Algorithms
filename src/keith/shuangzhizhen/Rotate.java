package shuangzhizhen;

/**
 * @author MX.Y
 * @DATE 2022-05-26 14:37
 */
public class Rotate {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int k = 3;
        Rotate r = new Rotate();
        r.rotate(nums, k);
        for (int num : nums) {
            System.out.print(num + "->");
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int a, int b) {
        // 用双指针
        int i = a, j = b;
        while(i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }


}
