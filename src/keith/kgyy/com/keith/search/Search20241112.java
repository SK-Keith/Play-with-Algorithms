package kgyy.com.keith.search;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/11/12 0012 14:11
 */
public class Search20241112 {

    /**
     * 功能描述
     * 给定⼀个排序数组和⼀个⽬标值，在数组中找到⽬标值，并返回其索引。如果⽬标值不存在于数组中，返回
     * 它将会被按顺序插⼊的位置。
     * 请必须使⽤时间复杂度为 O(log n) 的算法。
     * @author yaomianxian.
     * @date 2024/11/12 0012 14:12
     */
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) >> 1;
            if(nums[mid] > target) {
                r = mid - 1;
            }else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }
}
