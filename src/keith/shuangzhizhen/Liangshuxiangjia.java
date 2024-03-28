package shuangzhizhen;

/**
 * 两数相加
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/submissions/
 * @author MX.Y
 * @DATE 2022-03-12 11:15
 */
public class Liangshuxiangjia {

//    public int[] twoSum(int[] numbers, int target) {
//        int length = numbers.length;
//        int result[] = new int[2];
//        for (int i = 0;i < length;i++) {
//            int left = i, right = i + 1;
//            while (right < length) {
//                if (numbers[left] + numbers[right] == target) {
//                    result[0] = left + 1;
//                    result[1] = right + 1;
//                }
//                right++;
//            }
//        }
//        return result;
//    }

//    public int[] twoSum(int[] numbers, int target) {
//        for (int i = 0; i < numbers.length; ++i) {
//            int low = i + 1, high = numbers.length - 1;
//            while (low <= high) {
//                int mid = (high - low) / 2 + low;
//                if (numbers[mid] == target - numbers[i]) {
//                    return new int[]{i + 1, mid + 1};
//                } else if (numbers[mid] > target - numbers[i]) {
//                    high = mid - 1;
//                } else {
//                    low = mid + 1;
//                }
//            }
//        }
//        return new int[]{-1, -1};
//
//    }

    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;

        for (int i = 0; i < length; i++) {
            int low = i, high = length - 1;
            while(low < high) {
                int mid = (high - low)/2 + low;
                if (numbers[low] == target - numbers[mid]) {
                    return new int[]{low + 1, mid + 1};
                } else if (numbers[low] < target - numbers[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        Liangshuxiangjia l = new Liangshuxiangjia();
        int nums[] = new int[]{2,3,4};
        int[] ints = l.twoSum(nums, 6);
        for (int i : ints) {
            System.out.print(i + "\t");
        }

    }
}
