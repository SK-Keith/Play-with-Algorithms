package guangdusousuo.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author MX.Y
 * @DATE 2023-01-11 17:03
 */
public class UpdateMatrix {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        // 先填充0，
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }

        // 广度搜索，根据填充的0向外遍历
        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int d = 0; d < 4; ++d) {
                int nx = i + dirs[d][0];
                int ny = j + dirs[d][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !seen[nx][ny]) {
                    dist[nx][ny] = dist[i][j] + 1;
                    queue.offer(new int[]{nx, ny});
                    seen[nx][ny] = true;
                }
            }
        }

        return dist;
    }


}
