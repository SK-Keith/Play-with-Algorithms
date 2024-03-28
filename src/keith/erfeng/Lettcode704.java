package erfeng;

/**
 * https://leetcode.cn/problems/binary-search/
 * 二分
 * @author MX.Y
 * @DATE 2022-05-23 22:28
 */
public class Lettcode704 {

    public int search(int[] nums, int target) {
        int left = 0,right = nums.length -1;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            System.out.println(mid);
            if(nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private boolean isBadVersion(int i) {
        if (i < 4) {
            return false;
        } else {
            return true;
        }
    }

    public int search2(int n) {
        int left = 0, right = n;
        while(left < right) {
            int mid = left + ((right - left) >> 1);
            boolean flag = isBadVersion(mid);
            if (flag) {
                // 如果是错误版本，要判断是不是第一个错误
                flag = isBadVersion(mid - 1);
                if (!flag) {
                    // 不是错误版本，则mid为第一个错误版本
                     return mid;
                }
                // 是错误版本，右移
                right -= 1;
            } else {
                left += 1;
            }
        }
        return -1;

    }

    public int searchInsert(int[] nums, int target) {
        int l = 0,r = nums.length;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(nums[m] >= target) {
                r = m ;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    /**
     * https://leetcode.cn/problems/squares-of-a-sorted-array/
     * 有序数组的平方
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int size = nums.length - 1;
        int left = 0,right = size;
        int[] result = new int[nums.length];
        while(left <= right) {
            // 当左指针大于右指针结束，相等时代表一起有个相同的值
            int leftt = nums[left] * nums[left];
            int rightt = nums[right] * nums[right];
            if(leftt <= rightt) {
                result[size] = rightt;
                size--;
                right--;
            }else {
                result[size] = leftt;
                size--;
                left++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Lettcode704 l = new Lettcode704();
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 9;
        int search = l.search(nums, target);
        System.out.println(search);

//        int[] nums = new int[]{0};
//        int target = 9;
//        int search = l.search(nums, target);
//        System.out.println(search);


//        int n = 5;
//        int i = l.search2(n);
//        System.out.println(i);
//        int[] nums = new int[]{1,3,5,6};
//        int target = 7;
//        int i = l.searchInsert(nums, target);
//        System.out.println(i);
    }
}
