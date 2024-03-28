package shuangzhizhen;

/**
 * @author MX.Y
 * @DATE 2023-01-05 17:38
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int slow = 0, fast = 1;
        while(slow < fast) {
            int tt = target - numbers[slow];
            while(fast < numbers.length) {
                if (tt < numbers[fast]) {
                    fast++;
                }
            }

        }

        return null;
    }
}
