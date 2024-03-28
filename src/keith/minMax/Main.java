package minMax;

/**
 * @author MX.Y
 * @DATE 2021/11/23 14:47
 * @qq 2690399241
 */
public class Main {

    public static int[][][] m = new int[4][61][31];
    public static int[] v_arr = new int[]{0, 1, 6, 4};//物品体积
    public static int[] w_arr = new int[]{0, 2, 1, 4};//重量
    public static int[] t_arr = new int[]{0, 20, 60, 50};//价值

    public static void main(String[] args) {
        int n = 3;    //物品种类
        int v = 60;    //背包体积
        int w = 30;    //背包载重
        func(n, v, w);
        int s = m[n][v][w];
        System.out.println("最大值为：" + s);
    }

    public static void func(int n, int v, int w) {    //可选前3个物品，体积不超过60，重量不超过30

        int i = 0, j = 0;
        int x = 0, y = 0;
        int k = 0, max = 0;

        //假如都用第1个物品来填充，一个60*30的二维数组,第1个物品体积1，重量2，价值20，从体积看能放60个，从重量看能放15个
        //60行，30列的数组
        for (x = 0; x <= v; x++) {
            for (y = 0; y <= w; y++) {
                if ((x / v_arr[1] > 0) && (y / w_arr[1] > 0))//x>=v_arr[1]&&y>=w_arr[1]
                {
                    m[1][x][y] = min(x / v_arr[1], y / w_arr[1]) * t_arr[1];//重量和体积都满足的情况的个数,乘以价值等于m[1][x][y]取最大值
                } else {
                    m[1][x][y] = 0;
                }
            }
        }

        //因为有第2种物品，开始第二种物品来填充
        for (i = 2; i <= n; i++)//从第i=2开始填充
        {
            //m[2][x][y]为加上第二种物品的60*30的二维数组
            for (x = 0; x <= v; x++) {
                for (y = 0; y <= w; y++) {
                    max = m[i - 1][v][w];//原本这里为这里为m[i - 1][x][y]，但是最大值一定为m[i - 1][v][w],下面能减少计算

                    //开始算第2个物品了,第2个物品体积6，重量1，价值60，从体积看能放10个，从重量看能放30个
                    if ((x >= v_arr[i]) && (y >= w_arr[i])) {
                        for (k = 0; k <= min(x / v_arr[i], y / w_arr[i]); k++) {
                            if ((m[i - 1][x - k * v_arr[i]][y - k * w_arr[i]] + k * t_arr[i]) > max)//找出符合的最大的
                            {
                                max = (m[i - 1][x - k * v_arr[i]][y - k * w_arr[i]] + k * t_arr[i]);
                                String str = String.format("物品%d:%d个,物品%d:%d个", i - 1, min((x - k * v_arr[i]) / v_arr[i - 1], (y - k * w_arr[i]) / w_arr[i - 1]), i, k);
                                System.out.println(str);
                            }
                        }
                        m[i][x][y] = max;
                    } else {
                        m[i][x][y] = m[i - 1][x][y];
                    }
                }
            }
        }
    }

    public static int min(int a, int b) {
        int m;
        m = a;
        if (b < a)
            m = b;
        return m;
    }
}
