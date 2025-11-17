package kgyy.com.keith.search;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/09/5 0005 13:39
 */
public class Search20240905 {

    public static int search(int[] arrays, int target) {
        int length = arrays.length;
        int left = 0, right = length - 1;
        while(left < right) {
            int mid = left + (right - left) >> 1;
            if (arrays[mid] < target) {
                left = mid + 1;
            } else if (arrays[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
