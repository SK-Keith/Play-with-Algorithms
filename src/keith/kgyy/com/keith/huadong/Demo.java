package kgyy.com.keith.huadong;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/02/26 0026 14:24
 */
public class Demo {

    public static void main(String[] args) {
        EqualSubstring solution = new EqualSubstring();

        // 测试用例 1
        String s1 = "abcd";
        String t1 = "bcde";
        int maxCost1 = 3;
        System.out.println(solution.equalSubString(s1, t1, maxCost1)); // 预期输出: 3

        // 测试用例 2
        String s2 = "abcd";
        String t2 = "acde";
        int maxCost2 = 0;
        System.out.println(solution.equalSubString(s2, t2, maxCost2)); // 预期输出: 1

        // 测试用例 3
        String s3 = "abcd";
        String t3 = "abce";
        int maxCost3 = 1;
        System.out.println(solution.equalSubString(s3, t3, maxCost3)); // 预期输出: 4

        // 测试用例 4
        String s4 = "abcd";
        String t4 = "abcd";
        int maxCost4 = 10;
        System.out.println(solution.equalSubString(s4, t4, maxCost4)); // 预期输出: 4

        // 测试用例 5
        String s5 = "kitten";
        String t5 = "sitting";
        int maxCost5 = 5;
        System.out.println(solution.equalSubString(s5, t5, maxCost5)); // 预期输出: 5
    }
}
