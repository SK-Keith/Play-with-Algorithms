package kgyy.com.keith.shuangzhizhen;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/11/11 0011 16:25
 */
public class Subsequence {

    /**
     *
     * @param s 子串
     * @param t 原字符串
     * @return
     */
    public static boolean isSubsequence(String s,String t) {
        int i = 0, j = 0;
        while(i<s.length() && j<t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        boolean subsequence = isSubsequence("abc", "ahbgdc");
        System.out.println(subsequence);
        subsequence = isSubsequence("abe", "ahbgdc");
        System.out.println(subsequence);
    }
}
