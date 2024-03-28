package lettcode;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @author MX.Y
 * @DATE 2021/12/16 21:28
 */
public class Huiwenchuan {
    public static String longestPalindrome(String s) {
        int maxLen = 1;
        int index = 0;
        char[] chars = s.toCharArray();
        if (chars.length < 2) {
            return s;
        }
        int size = chars.length;
        boolean[][] flag = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            flag[i][i] = true;
        }

        for (int L = 2; L <= size; L++) {
            for (int i = 0; i < size; i++) {
                int j = L + i - 1;

                if (j >= size) {
                    break;
                }
                if (chars[i] != chars[j]) {
                    flag[i][j] = false;
                } else {
                    if (j - i < 3) {
                        flag[i][j] = true;
                    } else {
                        flag[i][j] = flag[i + 1][j - 1];
                    }
                }
                if (flag[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    index = i;
                }
            }

        }
        return s.substring(index, maxLen);


    }

    public static void main(String[] args) {
        String s = "cbababa";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }
}
