package shuangzhizhen;

/**
 * @author MX.Y
 * @DATE 2022-05-26 17:04
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while(left <= right) {
            int result = numbers[left] + numbers[right];
            if (result < target) {
                left++;
            } else if (result > target) {
                right--;
            } else {
//                return new int[]{left+1, right+1};
                break;
            }
        }
        return new int[]{left+1, right+1};
//        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        int[] nums = new int[]{2,7,9,11};
        int target = 9;
        int[] ints = t.twoSum(nums, target);
        for (int num : ints) {
            System.out.print(num + "->");
        }
    }
}
