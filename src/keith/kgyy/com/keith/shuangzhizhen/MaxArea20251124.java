package kgyy.com.keith.shuangzhizhen;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/11/24 0024 15:07
 */
public class MaxArea20251124 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int length = height.length;
        int left = 0, right = length - 1;
        while(left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int area =  w * h;
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
