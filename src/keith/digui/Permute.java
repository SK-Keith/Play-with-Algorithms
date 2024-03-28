package digui;

import utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * https://leetcode.cn/problems/permutations/
 * @author MX.Y
 * @DATE 2022-12-01 20:53
 */
public class Permute {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        PrintUtils.printListList(permute);
    }
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth,
                            List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 非叶子结点，依次选择元素
        for(int i = 0;i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                System.out.println("  递归之前 => " + path);
                dfs(nums, len, depth + 1, path, used, res);

                // 进行回溯，回到开始的状态
                used[i] = false;
                path.remove(path.size() - 1);
                System.out.println("递归之后 => " + path);
            }
        }
    }


//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        Deque<Integer> path = new ArrayDeque<>();
//        dfs(res, path, 0, nums);
//        return res;
//    }
//
//    private static void dfs(List<List<Integer>> res, Deque<Integer> path, int begin, int[] nums) {
//        if (path.size() == nums.length) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = begin; i < nums.length; i++) {
//            path.addLast(nums[i]);
//
//            dfs(res, path, begin + 1, nums);
//
//            path.clear();
//        }
//
//    }
}
