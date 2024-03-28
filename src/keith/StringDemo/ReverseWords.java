package StringDemo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author MX.Y
 * @DATE 2023-03-12 13:59
 */
public class ReverseWords {

    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
//        List<String> wordList = Arrays.asList(s.split("\\n"));
//        List<String> wordList = Arrays.asList(s.split("\\S+"));// 废物
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static void main(String[] args) {
        String s = "the sky is blue,\n" +
                "apple is red\t";
        ReverseWords r = new ReverseWords();
        String s1 = r.reverseWords(s);
        System.out.println(s1);
    }

}
