package minMax;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author MX.Y
 * @DATE 2021/11/23 22:03
 * @qq 2690399241
 * @linked: https://acwing.com/solution/content/1704/
 */
public class Main3 {
    public static void main(String[] args) {
        // N个物品
        int N;

        // 背包体积
        int V;

        // 背包承受最大的重量
        int M;

        // 每个物品的体积
        int[] v;

        // 每一个物品的重量
        int[] m;

        // 每一个物品的价值
        int[] w;

        // start input
        Scanner input = new Scanner(System.in);
        N = 5;
        V = 8;
        M = 10;
        v = new int[N + 1];
        m = new int[N + 1];
        w = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                v[i] = 3;
                m[i] = 6;
                w[i] = 2;
            }
            if (i == 2) {
                v[i] = 5;
                m[i] = 1;
                w[i] = 4;
            }
            if (i == 3) {
                v[i] = 4;
                m[i] = 2;
                w[i] = 6;
            }
            if (i == 4) {
                v[i] = 2;
                m[i] = 4;
                w[i] = 3;
            }
            if (i == 5) {
                v[i] = 6;
                m[i] = 8;
                w[i] = 2;
            }
//            v[i] = input.nextInt();
//            m[i] = input.nextInt();
//            w[i] = input.nextInt();
        }
//        input.close();
        Main3 solution = new Main3();
        // System.out.println(solution.two_dimension_knapsack_problem_1(N,V,M,v,m,w));
        System.out.println(solution.two_dimension_knapsack_problem_2(N,V,M,v,m,w));
    }

    /**
     * 传统解法，即没有优化的解法，这个解法对于n种约束需要构建一个n维的dp矩阵
     * @param N 题目提供N个物品
     * @param V 背包的总体积
     * @param M 背包承受最大的重量
     * @param v 每个物品的体积 v[i],长度为N+1,第0位无用
     * @param m 每个物品的重量 m[i],长度为N+1,第0位无用
     * @param w 每个物品的价值 w[i],长度为N+1,第0位无用
     * @return 在给定物品，背包总体积以及背包最大重量的情况下，背包能装的物品的最高总价值
     */
    public int two_dimension_knapsack_problem_1(int N, int V, int M, int[] v, int[] m, int[] w){
        int[][][] dp = new int[N+1][V+1][M+1];
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= V; j++){
                for(int k = 1; k <= M; k++){
                    if(j < v[i] || k < m[i]){
                        // 客观条件限制，不能选择当前物品N
                        dp[i][j][k] = dp[i-1][j][k];
                    }else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-v[i]][k-m[i]] + w[i]);
                    }
                }
            }
        }
        return dp[N][V][M];
    }

    /**
     *  优化版
     * @param N 题目提供N个物品
     * @param V 背包的总体积
     * @param M 背包承受最大的重量
     * @param v 每个物品的体积 v[i],长度为N+1,第0位无用
     * @param m 每个物品的重量 m[i],长度为N+1,第0位无用
     * @param w 每个物品的价值 w[i],长度为N+1,第0位无用
     * @return 在给定物品，背包总体积以及背包最大重量的情况下，背包能装的物品的最高总价值
     */
    public int two_dimension_knapsack_problem_2(int N, int V, int M, int[] v, int[] m, int[] w) {
        List<String> msgs = new ArrayList<>();
        List<GoodTrend> gts = new ArrayList<>();
        int[][] dp = new int[V+1][M+1];
        for(int i = 1; i <= N; i++){
            for(int j = V; j >= 1; j--){
                for(int k = M; k>= 1; k--){
                    if(j < v[i] || k < m[i]){
                        // 客观条件限制，不能选择当前物品N
                        dp[j][k] = dp[j][k];
                    }else {
                        StringBuilder msg = new StringBuilder("二选一，程序目前最大值：" + dp[j][k] + " VS 前价值：" + dp[j-v[i]][k-m[i]] + "加第" + i + "件物品的价值：" + w[i]);
                        dp[j][k] = Math.max(dp[j][k], dp[j-v[i]][k-m[i]] + w[i]);
                        msg.append("，程序选最大值后得到的价值为：").append(dp[j][k]);
                        if (!msgs.contains(msg.toString())) {
                            msgs.add(msg.toString());

                            GoodTrend gt = new GoodTrend();
                            gt.setCurrVal(w[i]);//
                            gt.setMaxVal(dp[j][k]);
                            gt.setLastVal(dp[j-v[i]][k-m[i]]);
                            gt.setWhichOne(i);//id
                            gts.add(gt);
                        }
                    }
                }
            }
        }
        msgs.forEach(System.out::println);
        List<GoodTrend> gts1 = gts.stream().filter(gt -> gt.getLastVal() + gt.getCurrVal() == gt.getMaxVal()).collect(Collectors.toList());
        int maxVal = dp[V][M];
        StringBuilder trend = new StringBuilder();
        int val = 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (GoodTrend gt1 : gts1) {
            if (map.containsKey(gt1.getLastVal())) {
                map.get(gt1.getLastVal()).add(gt1.getCurrVal());
            } else {
                List<Integer> array = new ArrayList<>();
                array.add(gt1.getLastVal());
                map.put(gt1.getLastVal(), array);
            }
        }
//        System.out.println(trend);
//        System.out.println("条数有：" +msgs.size());
        return dp[V][M];
    }
    /**
     * 所谓的优化，就是省去了代表N的那一维，即将：
     * dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-v[i]][k-m[i]] + w[i]);
     * 优化为
     * dp[j][k] = Math.max(dp[j][k], dp[j-v[i]][k-m[i]] + w[i]);
     * 这样整体的空间复杂度可以除以N，空间复杂度降低了；时间复杂度不变，还是三层循环
     *
     * 优化需要对遍历的顺序做一点改变，以保证遍历的时候，拿到的数据是 真·[i-1] 时刻的，而不是被更新过了的
     * 如果不修改遍历的顺序，更新矩阵数据的时候时，对于体积V和质量M ,是按照从小到大的顺序更新的，
     * 即，在计算dp[j][k] = Math.max(dp[j][k], dp[j-v[i]][k-m[i]] + w[i]) 时，
     * 本来要求dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-v[i]][k-m[i]] + w[i]) ，但是由于这里代表N的维度没有了，
     * 造成dp[i-1][j-v[i]][k-m[i]]被提前更新为了dp[i][j-v[i]][k-m[i]]，这样拿到的数据是错误的，最后的结果也是错误的
     * （这样做的效果，实际上等于计算了一个二维约束下的完全背包问题，而不是二维约束下的01背包问题）
     *
     * 通过改变 j 和 k 的遍历顺序，保证在更新dp[j][k]时，dp[j-v[i]][k-m[i]]实际上还是dp[i-1][j-v[i]][k-m[i]]，
     * 即 V 上小于 v ，M 上小于 k 的值，都没有更新过，还是之前的状态（i-1的状态），达到正确缩减维度的效果
     */
}
