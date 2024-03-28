package shuangzhizhen;

/**
 * @author MX.Y
 * @DATE 2022-05-27 15:48
 */
public class ReverseWords {

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = 0;

        while(right < chars.length) {
            int side = right + 1;
            if (side == chars.length || chars[side] == ' ') {
                side = right;
                while(left < right) {
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                    left++;
                    right--;
                }
                right = side + 2;
                left = right;
            } else {
                right++;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        ReverseWords r = new ReverseWords();
        String s = r.reverseWords("Let's take LeetCode contest");
        System.out.println(s);
    }


}
