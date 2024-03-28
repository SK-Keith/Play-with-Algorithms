package dongtai;

/**
 * @author MX.Y
 * @DATE 2021/12/19 19:58
 */
public class Faguan2 {
    public static void main(String[] args) {
        int n = 2;
        int[][] trust = {{1, 2}};
        System.out.println(findJudge(n, trust));
    }

    private static int findJudge(int n, int[][] trust) {
        int[] in = new int[n+1];
        int[] out = new int[n+1];
        for (int[] t: trust) {
            int a = t[0];
            int b = t[1];
            in[b]++;
            out[a]++;
        }

        for (int i = 1;i<=n;i++) {
            if (in[i] == n -1 && out[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
