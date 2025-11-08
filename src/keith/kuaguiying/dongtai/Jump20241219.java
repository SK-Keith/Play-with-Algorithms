package com.keith.dongtai;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/19 0019 13:46
 */
public class Jump20241219 {

    /**
     * 使用贪心算法，每个位置上能跳到最远的距离，直到到达最远距离再跳一次
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int end = 0;
        int farest = 0;
        int jump = 0;
        for(int i = 0;i < nums.length - 1;i++) {
            farest = Math.max(farest, i + nums[i]);
            if (end == i) {
                end = farest;
                jump++;
                if (end >= nums.length - 1) {
                    break;
                }
            }
        }
        return jump;
    }


}
