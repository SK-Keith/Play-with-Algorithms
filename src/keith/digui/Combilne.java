package digui;

import com.google.common.base.Stopwatch;
import utils.PrintUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 合并
 * https://leetcode.cn/problems/combinations/
 * @author MX.Y
 * @DATE 2022-12-01 15:29
 */
public class Combilne {
    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        List<List<Integer>> combine = combine1(70, 4);
        PrintUtils.printListList(combine);
        stopwatch.stop();
        System.out.println(stopwatch);
    }


    public static List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
//        if ()
        Deque<Integer> path = new ArrayDeque<>();
        dfs1(n, k, 1, path, res);
        return res;
    }

    private static void dfs1(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // for循环
        for (int i = begin; i<= n;i++) {
            // 向路径变量里添加一个数
            path.addLast(i);
            dfs1(n, k, i+1, path, res);
            path.removeLast();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }

        // 为了防止底层动态数组扩容，初始化时指定最大长度
        Deque<Integer> path = new ArrayDeque<>(k);
        dfs(1, n, k, path, res);
        return res;
    }

    private static void dfs(int begin, int n, int k, Deque<Integer> path, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 基础版本的递归终止条件 if (begin == n + 1)
        if (begin > n - k + 1) {
            return;
        }
        // 不选当前考虑的数begin, 直接递归到下一层
        dfs(begin + 1, n, k, path, res);
        // 不选当前考虑的数begin,
        path.addLast(begin);
        dfs(begin + 1, n, k-1, path, res);

        path.removeLast();


    }

}
