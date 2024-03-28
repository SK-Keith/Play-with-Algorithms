package shuangzhizhen;

import utils.PrintUtils;

/**
 * @author MX.Y
 * @DATE 2022-05-26 18:04
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int l =0, r = s.length - 1;
        while(l < r) {
            s[l] ^= s[r];
            s[r] ^= s[l];
            s[l] ^= s[r];
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        ReverseString s = new ReverseString();
        char[] cs = new char[]{'h', 'e', 'l', 'l', 'o'};
//                {"h","e","l","l","o"};
        s.reverseString(cs);
        PrintUtils.printArray(cs);
    }
}
