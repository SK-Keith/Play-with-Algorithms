package baoli;

import java.util.HashMap;
import java.util.Map;

/**
 * 压缩字符串https://leetcode.cn/problems/compress-string-lcci/?favorite=xb9lfcwi
 * 暴力
 * @author MX.Y
 * @DATE 2022-12-09 7:25
 */
public class CompressString {
    public static void main(String[] args) {
        CompressString s = new CompressString();
        String a = s.compressString("aabcccccaaa");
        System.out.println(a);
    }
    public String compressString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i <chars.length; i++) {
            if (i > 0) {
                if (chars[i] == chars[i-1]) {
                    num = num+1;
                } else {
                    sb.append(num).append(chars[i]);
                    num = 1;
                }
            } else {
                sb.append(chars[i]);
                num = 1;
            }
        }
        sb.append(num);
        if (sb.length() < s.length()){
            return sb.toString();
        } else {
            return s;
        }
    }
}
