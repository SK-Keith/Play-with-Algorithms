package erfeng;

/**
 * 错误版本
 * https://leetcode-cn.com/problems/first-bad-version/
 *
 * @author MX.Y
 * @DATE 2022-03-02 23:57
 */
public class Cuowubanben {

    private boolean isBadVersion(int mid) {
        if (mid < 4) {
            return false;
        } else {
            return true;
        }
    }

    public int firstBadVersion(int n) {
        int left = 0,right = n;
        if (isBadVersion(n)) {
            return 1;
        }
        while (left < right) {
            int middle = (right - left) / 2 + left;
            boolean flag = isBadVersion(middle);
            if (!flag) {
                // 如果false，则说明还没有查到错误版本，需要再往右边，左边界右移
                left += 1;
            } else {
                // 如果是true，不一定是第一个错误，需要再查一次上一个版本
                flag = isBadVersion(middle - 1);
                if (!flag) {
                    // 如果上一个版本是不是错误版本，则当前版本就是第一个错误版本
                    return middle;
                }
                // 如果是false，说明不是第一个错误版本，右边界左移
                right -= 1;
            }
        }
        return -1;

    }

    public int firstBadVersion2(int n) {


        return -1;
    }

    public static void main(String[] args) {
        Cuowubanben c = new Cuowubanben();
        System.out.println(c.firstBadVersion(5));
    }
}
