package kgyy.com.keith.n1;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/11/11 0011 20:44
 */
public class FactorialTrailingZeros {

    // 计算 n! 尾随零的数量
    public static int countTrailingZeros(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    // 计算尾随零数量为 K 的阶乘数的个数
    public static int countFactorialsWithKZeros(int K) {
        int count = 0;
        int n = 0;

        // 从 0! 到 n! 中查找尾随零数量为 K 的阶乘数
        while (true) {
            int trailingZeros = countTrailingZeros(n);
            if (trailingZeros == K) {
                count++;
            } else if (trailingZeros > K) {
                // 一旦尾随零的数量大于 K，停止查找
                break;
            }
            n++;
        }
        return count;
    }

    public static void main(String[] args) {
        int K = 5;
        for(int i = 0;i<20;i++) {
            System.out.println("The number of factorials with " + i + " trailing zeros is: " + countFactorialsWithKZeros(i));
        }
    }
}
