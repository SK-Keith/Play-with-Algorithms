package com.keith.deque;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/07/26 0026 14:23
 */
public class Demo {

    public static void main(String[] args) {
        int[] nums = new int[]{73,74,75,71,69,72,76,73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] ints = dailyTemperatures.dailyTemperatures(nums);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
