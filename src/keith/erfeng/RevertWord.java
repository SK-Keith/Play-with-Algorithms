package erfeng;

import shuangzhizhen.ReverseWord;

/**
 * @author MX.Y
 * @DATE 2022-12-08 17:09
 */
public class RevertWord {
    public static void main(String[] args) {
        String s = "i have a apple";
        ReverseWord w = new ReverseWord();
        String s1 = w.reverseWords(s);
        System.out.println(s1);
    }

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder ss = new StringBuilder();
        for (String word : words) {
            char[] chars = word.toCharArray();
            reverString(chars);
            ss.append(chars).append(" ");
        }
        return ss.toString().substring(0, s.length());
    }

    private void reverString(char[] chars) {
        int left = 0, right = chars.length - 1;
        while(left < right) {
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left] ^= chars[right];
            left++;
            right--;
        }
    }
}
