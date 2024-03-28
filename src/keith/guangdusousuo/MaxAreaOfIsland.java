package guangdusousuo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author MX.Y
 * @DATE 2022-12-19 17:03
 */
public class MaxAreaOfIsland {
// 给你一个大小为 m x n 的二进制矩阵 grid 。
//
//岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
// 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
//
//岛屿的面积是岛上值为 1 的单元格的数目。
//
//计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
//实例一
// 输入：grid =
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
//示例 2：
//
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
    public static void main(String[] args) {
        int[][] image = new int[3][3];
        image[0][0] = 0;
        image[0][1] = 0;
        image[0][2] = 1;
        image[0][3] = 0;
        image[0][4] = 0;
        image[0][5] = 0;
        image[0][6] = 0;
        image[0][7] = 0;
        image[0][8] = 0;
        image[0][8] = 0;
        image[0][6] = 0;
        image[0][7] = 0;
        image[0][8] = 0;
        image[0][8] = 0;


        image[0][2] = 1;
        image[1][0] = 1;
        image[1][1] = 1;
        image[1][2] = 0;
        image[2][0] = 1;
        image[2][1] = 0;
        image[2][2] = 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        // 对每个格子进行遍历
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 如果是岛屿进行操作
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }
    private int dfs(int i, int j, int[][] grid) {
        // 不符合条件的岛屿直接返回
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        // 将陆地下沉，置为0
        grid[i][j] = 0;
        int num = 1;
        // 对四个方向的位置判断并获取最后的岛屿数
        num += dfs(i + 1, j, grid);
        num += dfs(i - 1, j, grid);
        num += dfs(i, j + 1, grid);
        num += dfs(i, j - 1, grid);
        return num;
    }

    /*public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        for (int i = 0;i< grid.length;++i) {
            for (int j = 0;j<grid[0].length;++j) {
                int cur = 0;
                Deque<int[]> deque = new LinkedList<>();
                if (grid[i][j] != 0) {
                    deque.offer(new int[]{i, j});
                    while (!deque.isEmpty()) {
                        int[] poll = deque.poll();
                        int x = poll[0];
                        int y = poll[1];
                        for (int m = 0;m<4;m++) {
                            int nx = x + dx[m];
                            int ny = y + dy[m];
                            if (grid[nx][ny] != 1 && nx >=0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                                cur++;
                            }
                        }
                    }
                }
                result = Math.max(result, cur);
            }

        }




    }*/

    /*public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                int cur = 0;
                Queue<Integer> queuei = new LinkedList<Integer>();
                Queue<Integer> queuej = new LinkedList<Integer>();
                queuei.offer(i);
                queuej.offer(j);
                while (!queuei.isEmpty()) {
                    int cur_i = queuei.poll();
                    int cur_j = queuej.poll();
                    if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
                        continue;
                    }
                    ++cur;
                    grid[cur_i][cur_j] = 0;
                    int[] di = {0, 0, 1, -1};
                    int[] dj = {1, -1, 0, 0};
                    for (int index = 0; index != 4; ++index) {
                        int next_i = cur_i + di[index], next_j = cur_j + dj[index];
                        queuei.offer(next_i);
                        queuej.offer(next_j);
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }

    public int maxArea(int[][] grid) {
        int ans = 0;
        // 遍历横纵坐标格子
        for (int i = 0;i != grid.length;++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                int cur = 0;
                // 使用两个栈作为队列，先进先出的特性可以快速添加
                Queue<Integer> queuei = new LinkedList<Integer>();
                Queue<Integer> queuej = new LinkedList<Integer>();
                queuei.offer(i);
                queuej.offer(j);
                while(!queuei.isEmpty()) {
                    int cur_i = queuei.poll();
                    int cur_j = queuej.poll();
                    // 移动的下一个方格满足条件，不能超过当前方格，同时当前值不等于1,1的是未统计到的
                    if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
                        continue;
                    }
                    ++cur;
                    // 统计到就置位0
                    grid[cur_i][cur_j] = 0;
                    // 定义方格的上下左右四个格子，所以像左下角的格子就不会统计到
                    int[] di = {0, 0, 1, -1};
                    int[] dj = {1, -1, 0, 0};
                    for(int index = 0;index != 4; ++index) {
                        // 每一次改变起始坐标
                        int next_i = cur_i + di[index];
                        int next_j = cur_j + dj[index];
                        queuei.offer(next_i);
                        queuej.offer(next_j);
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }*/

}
