package dongtai;

/**
 * 极客时间-动态规划实践
 * @author MX.Y
 * @DATE 2021/12/18 16:44
 */
public class Lujing {

    private static int[][] matrix = {{1,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}};
    private static int[][] mem = new int[4][4];
    private static int num = 0;

    public static void main(String[] args) {
        int n = 4;
        int min = minDist(n-1, n-1);
        System.out.println(min);
        System.out.println(num);
    }

    public static int minDist(int i, int j) {
        num++;
        if (i == 0 && j==0) return matrix[0][0];
        if (mem[i][j] > 0) return mem[i][j];
        int minLeft = Integer.MAX_VALUE;
        if (j - 1 >= 0) {
            minLeft = minDist(i, j-1);
        }
        int minUp = Integer.MAX_VALUE;
        if (i-1 >= 0) {
            minUp = minDist(i - 1, j);
        }
        int currMinDist = matrix[i][j] + Math.min(minLeft, minUp);
        mem[i][j] = currMinDist;
        return currMinDist;
    }
}
