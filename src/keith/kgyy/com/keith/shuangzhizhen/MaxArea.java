package kgyy.com.keith.shuangzhizhen;

/**
 * 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
 *
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
            int h = Math.min(height[left], height[right]);
            int area = w * h;
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
