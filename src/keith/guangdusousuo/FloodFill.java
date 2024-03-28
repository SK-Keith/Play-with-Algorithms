package guangdusousuo;

import utils.PrintUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author MX.Y
 * @DATE 2022-12-18 21:47
 */
public class FloodFill {


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        // 用于判断是否需要渲染
        int oldColor = image[sr][sc];
        if (oldColor != color) {
            // 区别于深度遍历，多了空间复杂度
            // 使用容器存储下一个要处理的元素
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{sr, sc});
            image[sr][sc] = color;
            // 多出来的判断，截止条件
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                // 一样的遍历
                for (int i = 0;i< 4; i++) {
                    int nx = poll[0] + dx[i];
                    int ny = poll[1] + dy[i];
                    // 一样的条件判断
                    if (nx >= 0 && nx < image.length && ny >= 0 && ny < image[0].length && image[nx][ny] == oldColor) {
                        image[nx][ny] = color;
                        queue.offer(new int[]{nx, ny});
                    }

                }

            }
        }
        return image;

    }

    // 广度知道有多广，深度不知道有多深
    /*int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor != color) {
            dfs(image, sr, sc, color, oldColor);
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int oldColor) {
        if (image[sr][sc] == oldColor) {
            image[sr][sc] = color;
            for (int i = 0; i < 4; i++) {
                int nx = sr + dx[i];
                int ny = sc + dy[i];

                if (nx >= 0 && nx < image.length && ny >= 0 && ny < image[0].length) {
                    dfs(image, nx, ny, color, oldColor);
                }
            }
        }
    }*/









    /*int[] dx = new int[]{1, 0, 0, -1};
    int[] dy = new int[]{0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // 广度优先算法
        int currColor = image[sr][sc];
        if (currColor != color) {
            dfs(image, sr, sc, currColor, color);
        }
        return image;
    }

    public void dfs(int[][] image, int x, int y, int currColor, int color) {
        if (image[x][y] == currColor) {
            image[x][y] = color;
            for (int i = 0; i < 4; i++) {
                // 每一次改变起始坐标
                int mx = x + dx[i];
                int my = y + dy[i];
                // 移动的下一个方格颜色与当前染色前的方格相同，则进行染色
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, currColor, color);
                }
            }

        }


    }*/

    public static void main(String[] args) {
        FloodFill f = new FloodFill();
        int[][] image = new int[3][3];
        image[0][0] = 1;
        image[0][1] = 1;
        image[0][2] = 1;
        image[1][0] = 1;
        image[1][1] = 1;
        image[1][2] = 0;
        image[2][0] = 1;
        image[2][1] = 0;
        image[2][2] = 1;
        long s1 = System.currentTimeMillis();
        int[][] ints = f.floodFill(image, 1, 1, 2);
        PrintUtils.printArray(ints);
    }

    // 超时了
    /*public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //题解1：广度优先搜索;
        //先将坐标image[sr][sc]染色作为第一层,然后对其上下左右染色作为第二层;
        //再将第二层的分别的上下左右染色,作为第三层,以此类推;

        //定义移动上下左右四种情况
        int[] dx = new int[]{1, 0, 0, -1};
        int[] dy = new int[]{0, 1, -1, 0};

        //矩阵行列边界
        int m = image.length;
        int n = image[0].length;

        //判断初始颜色相同时返回原图,因为在本次染色前,原图已经符合"油漆桶"标准
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }

        //建立队列存储每一次要染色的方格x,y坐标
        Queue<int[]> queue = new LinkedList<>();
        //先将起始点染色
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;

        //开始广度优先搜索
        //外层循环改变起始坐标,内层循环改变朝4个方向移动
        //外层循环判断条件,当队列为空,则涂色完成
        while (!queue.isEmpty()) {

            //分解坐标
            int cell[] = queue.poll();
            int x = cell[0];
            int y = cell[1];

            //坐标移动判断条件是x,y坐标移动均在矩阵内,且移动的下一个方格颜色与当前(染色前)方格相同;
            for (int i = 0; i < 4; i++) {
                //每一次改变起始坐标
                int mx = x + dx[i];
                int my = y + dy[i];

                if (mx >= 0 && mx < m && my >= 0 && my < n && image[mx][my] == currColor) {
                    image[mx][my] = newColor;
                    queue.offer(new int[]{mx, my});
                }
            }
        }

        return image;
    }*/


}
