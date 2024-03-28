package shuangzhizhen;

/**
 * @author MX.Y
 * @DATE 2022-09-24 16:15
 */
public class ReverseWord {

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder s3 = new StringBuilder();
        for (String s2 : s1) {
            s3.append(reverseStr(s2.toCharArray())).append(" ");
        }
        return s3.substring(0, s3.length() - 1);
    }

    private String reverseStr(char[] s) {
        int l =0, r = s.length - 1;
        while(l < r) {
            s[l] ^= s[r];
            s[r] ^= s[l];
            s[l] ^= s[r];
            l++;
            r--;
        }
        return String.valueOf(s);
    }

    public static void main(String[] args) {
        String word = "Let's take LeetCode contest";
        ReverseWord reverseWord = new ReverseWord();
        String s = reverseWord.reverseWords(word);
        System.out.println(s);
    }
}
