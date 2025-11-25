package kgyy.com.keith.shuangzhizhen;

/**
 * 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 * @author yaomianxian
 * @date 2025/11/22 0022 9:44
 */
public class MaxArea {

    /**
     * 移动判断：左右指针，谁矮移谁
     * 面积计算：最低的高度 * 左右指针的长度
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int length = height.length;
        int left = 0, right = length - 1;
        int maxArea = 0;
        while(left < right) {
            int w = right - left;
            // 20251124，取错了，取成了最大，应该是最小值，对象也取错了，应该是高度的更小值
            int h = Math.min(height[left], height[right]);
            int area = w * h;
            // 这个盛水题目有两个最值，最小值的高度，最大值的面积
            maxArea = Math.max(area, maxArea);
            if (height[left] > height[right]) {
                // 20251122 右指针减一！！不是加
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
