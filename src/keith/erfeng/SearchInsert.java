package erfeng;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author MX.Y
 * @DATE 2022-03-27 10:18
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n -1;

        while (l <= r) {
            int mid = ((r - l)>>1) + l;
            System.out.print("mid:" +mid + "\t");
            if (nums[mid] < target) {
                l = mid + 1;
                System.out.print("l:" +l + "\t" + "r:" + r +"\t");
            } else {
                r = mid - 1;
                System.out.print("l:" +l + "\t" + "r:" + r +"\t");
            }
            System.out.println();
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        SearchInsert s = new SearchInsert();
        int result = s.searchInsert(nums, 2);
        System.out.println("result=" + result);
    }
}
