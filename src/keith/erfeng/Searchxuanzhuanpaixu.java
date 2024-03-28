package erfeng;

/**
 * @author MX.Y
 * @DATE 2022-04-09 10:02
 */
public class Searchxuanzhuanpaixu {

    public int search(int[] nums, int target) {
        int length = nums.length;
        int index = 0;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                index = i + 1;
                break;
            }
        }
        System.out.println("index = " + index);
        int l = index, r = length + index;
        while(l < r) {
            int mid = l + ((r - l) >> 1);
            int midd = mid >= length ? mid - length : mid;
            if (nums[midd] == target) {
                return midd;
            } else {
                if (r -l <= 1) {
                    break;
                } else if (nums[midd] > target) {
                    r = midd <= index ? midd + length : midd;
                } else {
                    l = midd <= index ? midd + length : midd;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3};
        int target = 1;
        Searchxuanzhuanpaixu s = new Searchxuanzhuanpaixu();
        int search = s.search(nums, target);
        System.out.println(search);

    }
}
