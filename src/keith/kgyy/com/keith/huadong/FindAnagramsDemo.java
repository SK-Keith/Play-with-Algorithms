package kgyy.com.keith.huadong;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/11/26 0026 14:19
 */
public class FindAnagramsDemo {
    public static void main(String[] args) {
        FindAnagrams solution = new FindAnagrams();

        // 测试用例
        System.out.println(solution.findAnagrams("cbaebabacd", "abc")); // [0, 6]
        System.out.println(solution.findAnagrams("abab", "ab"));        // [0, 1, 2]
        System.out.println(solution.findAnagrams("baa", "aa"));         // [1]
        System.out.println(solution.findAnagrams("abc", "d"));           // []
        System.out.println(solution.findAnagrams("a", "a"));             // [0]
        System.out.println(solution.findAnagrams("abc", "abcd"));       // []
    }
}
