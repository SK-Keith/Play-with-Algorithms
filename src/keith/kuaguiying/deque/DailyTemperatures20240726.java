package com.keith.deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调栈
 *
 * @author yaomianxian
 * @date 2024/07/26 0026 14:19
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for(int i = 0;i<length;i++) {
            int temperature = temperatures[i];
            while(!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                ans[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
