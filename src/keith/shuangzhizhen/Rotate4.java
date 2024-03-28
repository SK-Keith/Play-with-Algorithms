package shuangzhizhen;

/**
 * @author MX.Y
 * @DATE 2023-01-04 17:13
 */
public class Rotate4 {
    public void rotate(int[] nums, int k) {
        int size = nums.length - 1;

        k %= nums.length;

        trans(nums, 0, size);

        trans(nums, k, size);

        trans(nums, 0, k-1);
    }

    private void trans(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int k = 3;
        Rotate4 r = new Rotate4();
        r.rotate(nums, k);
        for (int num : nums) {
            System.out.print(num + "->");
        }
    }
}
