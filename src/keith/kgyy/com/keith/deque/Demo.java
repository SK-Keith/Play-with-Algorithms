package kgyy.com.keith.deque;

/**
 * 单调栈
 *  * 题目要求是根据每日温度列表，生成一个数组，其中每个元素表示需要等待多少天才能遇到更高的温度。如果没有更高的温度，则为0。例如，
 *  * 输入[73,74,75,71,69,72,76,73]，输出[1,1,4,2,1,1,0,0]
 *
 * @author yaomianxian
 * @date 2024/07/26 0026 14:23
 */
public class Demo {

    public static void main(String[] args) {
        int[] nums = new int[]{73,74,75,71,69,72,76,73};
        DailyTem20251112 dailyTemperatures = new DailyTem20251112();
        int[] ints = dailyTemperatures.dailyTem(nums);
//        int[] ints = Daily2.dailyTem(nums);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
