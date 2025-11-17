package kgyy.com.keith.dongtai;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/17 0017 13:18
 */
public class Jump20241217 {

    /**
     * 判断是否能跳关键在于跳的距离大于给定长度
     * 使用贪心算法实现
     * 如果某一时刻的最远距离超过或等于数组的最后一个位置，则说明可以跳到
     * 如果当前位置i超过了最远距离，说明无法到达该位置，也就不能到达最后的位置
     * @param nums
     * @return
     */
    public static boolean canjump(int[] nums) {
        int rightmost = 0;
        int n = nums.length;
        for(int i = 0;i< n;i++) {
            // 如果当前位置
            if (i <= rightmost) {
                rightmost = Math.max(i + nums[i], rightmost);
                if (rightmost >= n -1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 力扣45题（也可以使用动态规划）解题难度	更复杂（需要跟踪跳跃次数）	相对第55题简单（只需要判断是否能到达）
     * 计算最少多少步能到达数组的最后一个位置
     * 也是使用贪心算法，（也可以使用动态规划）
     * 区别于是否能跳，这个最少多少步，
     *              一是需要步数；
     *              二是需要每次的最远距离；
     *              三是当前已到达的最远距离（用于跳下一步）
     * 截止条件：当前已到达的最远距离大于数组的最后第二个位置
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int end = 0;
        int jump = 0;
        int farest = 0;
        for (int i = 0;i<nums.length - 1;i++) {
            farest = Math.max(i + nums[i], farest);
            if (end == i) {
                jump++;
                end = farest;
                if (end > nums.length - 1) {
                    break;
                }
            }
        }
        return jump;
    }




}
