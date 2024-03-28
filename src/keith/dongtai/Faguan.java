package dongtai;

/**
 * 法官
 * @author MX.Y
 * @DATE 2021/12/19 11:01
 */
public class Faguan {
    public static int findJudge(int n, int[][] trust) {
        int flag = -1;
        for (int i = 1; i<=n;i++) {
            for (int j = 1;j<=n;j++) {
                if (trust[j][i] == i) {
                    flag = -1;
                }
                if (trust[i][j] == j) {
                    flag = j;
                }
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] trust = new int[n+1][n+1];
        trust[1][2] = 2;
        int judge = findJudge(2, trust);
        System.out.println(judge);
    }
}
