package dongtai;

/**
 * @author MX.Y
 * @DATE 2021/12/21 9:28
 */
public class Zuidahe {
    private int get(int[] nums) {
        // 连续的情况下，当前步的最大值
        int pre = 0;
        // 整体的子数组最大值
        int maxAn = nums[0];

        for(int n : nums) {
            pre = Math.max(pre + n, n);
            maxAn = Math.max(pre, maxAn);
        }
        // 遍历到最后的pre是保证了连续的情况下，还能存多少，
        // 入股时机最佳，但不偷税
        // 遍历到最后的maxAn是得到了整体中局部连续的最大值，
        // 入股时机最佳，期间有交税最后没交税，相当于偷税了
        return maxAn;
    }

    public static void main(String[] args) {
        Zuidahe z = new Zuidahe();
        int[] nums = {-1, 2, -3, 1, 4, -1, 2, 1, -5, 2};
        int i = z.get(nums);
        System.out.println(i);
    }
}
