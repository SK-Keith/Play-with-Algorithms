package dongtai;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/heaters/solution/gong-nuan-qi-by-leetcode-solution-rwui/
 * @author MX.Y
 * @DATE 2021/12/20 22:00
 */
public class Fangwugongnuan {

    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int i = binarySearch(heaters, house);
            int j = i + 1;
            int leftDistance = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
            int rightDistance = j >= heaters.length ? Integer.MAX_VALUE : heaters[j] - house;
            int curDistance = Math.min(leftDistance, rightDistance);
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (nums[left] > target) {
            return -1;
        }
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
//        houses = [1,2,3], heaters = [2]
        int[] houses = {1,2,3,4};
        int[] heaters = {1,4};
        Fangwugongnuan f = new Fangwugongnuan();
        int radius = f.findRadius(houses, heaters);
        System.out.println(radius);
    }
}
