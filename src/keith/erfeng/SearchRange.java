package erfeng;

/**
 * @author MX.Y
 * @DATE 2022-04-07 23:46
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int start = -1,end = -1;
        int index = 0;
        for (int i=0;i<=length - 1;i++) {
            if (nums[i] == target  && index == 0) {
                start = i;
                end = i;
                index ++;
            } else if (nums[i] == target) {
                end = i;
                index ++;
            } else {

            }
        }
        int[] a = new int[]{start, end};
        return a;
    }

    public int[] searchRange2(int[] nums, int target) {
        // 先找>= target的第一个，再找>target的第一个
        int l = search(nums, target);
        int r = search(nums, target + 1);
        if (l == nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{l, r - 1};
    }

    private int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (r + l) >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        SearchRange r = new SearchRange();
        int[] ints = r.searchRange2(nums, 1);
        for (int i : ints) {
            System.out.print(i + "\t");
        }
    }
}
