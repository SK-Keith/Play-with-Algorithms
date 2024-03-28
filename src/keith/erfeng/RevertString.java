package erfeng;

import utils.PrintUtils;

/**
 * @author MX.Y
 * @DATE 2022-12-08 16:01
 */
public class RevertString {

    public void reverseString(char[] s) {
        int length = s.length - 1, i = 0;
        while (i < length) {
            s[i] ^= s[i];
            s[i] ^= s[length];
            i++;
            length--;
        }
    }

    public static void main(String[] args) {
        RevertString s = new RevertString();
        char[] chars = {'h', 'e', 'e', 'l', 'o'};
        PrintUtils.printArray(chars);
        s.reverseString(chars);
        PrintUtils.printArray(chars);
    }
}
