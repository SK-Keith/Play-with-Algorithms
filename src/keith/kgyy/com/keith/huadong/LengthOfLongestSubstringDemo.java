package kgyy.com.keith.huadong;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/11/26 0026 10:21
 */
public class LengthOfLongestSubstringDemo {
    public static void main(String[] args) {
        lengthOfLongestSubstring20251126 solution = new lengthOfLongestSubstring20251126();

        // 测试用例
        String[] testCases = {
                "abcabcbb",    // 标准案例
                "bbbbb",       // 全重复字符
                "pwwkew",      // 中间有重复
                "",            // 空字符串
                " ",           // 单个空格
                "au",          // 两个不同字符
                "a",           // 单个字符
                "dvdf",        // 重复出现在开头
                "abba",        // 回文型重复
                "tmmzuxt",     // 复杂案例
                "abcdeffedcba" // 对称重复
        };

        int[] expected = {3, 1, 3, 0, 1, 2, 1, 3, 2, 5, 6};

        System.out.println("测试结果：");
        System.out.println("字符串\t\t预期\t实际\t状态");
        System.out.println("---------------hashSet-------------------------");

//        for (int i = 0; i < testCases.length; i++) {
//            int result = solution.lengthOfLongestSubstring(testCases[i]);
//            String status = result == expected[i] ? "✓ 通过" : "✗ 失败";
//            System.out.printf("%-12s\t%d\t%d\t%s%n",
//                    "\"" + testCases[i] + "\"", expected[i], result, status);
//        }
        System.out.println("--------------hashMap--------------------------");
        for (int i = 0; i < testCases.length; i++) {
            int result = solution.lengthOfLongestSubstring(testCases[i]);
            String status = result == expected[i] ? "✓ 通过" : "✗ 失败";
            System.out.printf("%-12s\t%d\t%d\t%s%n",
                    "\"" + testCases[i] + "\"", expected[i], result, status);
        }
    }
}
