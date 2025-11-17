package kgyy.com.keith.dongtai;

/**
 * 动态规划-贪心算法
 * 给你一个非负整数数组nums，你最初位于数组的第一个位置，数组中的每个元素代表你在该位置可以跳跃最大长度，
 * 请你使用最少的跳跃次数到达数组的最后一个位置（假设你总是可以到达数组的最后一个位置）。
 * 示例1：输入：nums=[2,3，1，1,4]输出：2
 * 解释：跳到最后一个位置的最小跳跃数是2。从下标为0跳到下标为1的位置，跳1步，然后跳3步到达数组的最后一个位置
 * 疑惑1：遍历到nums.length不行？
 *      我们的目标是从数组的第一个位置（即索引 0）跳（重点是我们在nums.length - 1 -1 的位置跳了一次到了nums.length - 1）到数组的 最后一个位置，
 *      而不是跳到数组的末尾（在最后一个元素不用调了，所以不需要遍历了）。
 * 在每一步中，贪心策略选择的是能跳到的 最远位置。也就是说，当前跳跃区间结束后，我们选择下一跳的最远目标，以减少跳跃次数。
 * @author yaomianxian
 * @date 2024/11/26 0026 14:18
 */
public class Jump2 {
    /**
     * 力扣45题
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int jumps = 0;
        int end =0, farest = 0;
        int n = nums.length;
        for(int i = 0;i<n-1;i++) {
            farest = Math.max(i+nums[i], farest);
            if (end == i) {
                end = farest;
                jumps +=1;
                if (end > n) {
                    break;
                }
            }
        }
        return jumps;
    }

    /**
     * 力扣55题
     * @param nums
     * @return
     */
    public static boolean canjump(int[] nums) {
        int end = 0, farest = 0;
        for (int i = 0;i<nums.length;i++) {
            farest = Math.max(i + nums[i], farest);
            if (i == end) {
                end = farest;
                if (end >= nums.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        int jump = jump(nums);
        System.out.println(jump);
    }
}
