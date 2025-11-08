package com.keith.deque;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 单调栈
 *
 * @author yaomianxian
 * @date 2024/07/26 0026 14:19
 */
public class DailyTemperatures {

    /**
     * 栈的作用是存储温度的下标
     * 栈内保持从大到小的顺序，
     * 每当我们遇到一个比栈顶温度还要高的温度时，就意味着栈顶下标对应的温度的“下一天温度更高”的下标，即i
     * {73,74,75,71,69,72,76,73}
     * 1. 比赛开始，73先上场，没有对手，在擂台上（deque）排着队
     * 2. 下一个选手74上场，找擂台上的对手73，74打赢73，然后73就得下台，并且头上写着输给73，差距是对方的下标减自己的下标为1（1-0）
     * 3. 下一个选手75上传，找擂台上的对手74, 75打赢74，然后74就得下台，并且头上写着输给74，差距是对方的下标减自己的下标为1（2-1）
     * 4. 下一个选手71上场，找擂台上的对手75，71输给75，然后输的一方得代替75打比赛，所以擂台上现在排着队，下一个选手要先跟71打，再跟75打（deque下标：2->3）
     * 5. 下一个选手69上场，找擂台上的对手71, 69输给71，然后继续排队（2->3->4）
     * 6. 下一个选手72上场，找擂台上的对手69, 72打赢69，然后69就得下台，并且头上写着输给72，差距是对方的下标减自己的下标为1（5-4），队列（2->3）
     *      还没完，刚刚说输的一方是代替打的，现在轮到下一个（先进先出的队列），72打赢71，然后71就得下台，连赢两场！！！71的差距为2（5-3），队列（2）
     *      还没完，下一个75, 72输给75，结果72得代替75打比赛，继续排队（2->5）
     * 7. 下一个选手76上传，打赢72，结果72的差距为1（6-5），队列（2）
     *      还没完，76还打赢了75，结果75的差距为4（6-2），队列只剩下当前的76（6）
     * 8. 下一个选手73上场，73输给76，继续排队（6->7）
     * 9. 比赛结果出炉，每个选手的差距为：1,1,4,2,1,1,0,0
     * 观察队列都是单调递增的队列，栈顶下标对应的温度到栈底下标对应的温度是单调递增
     * 使用队列的Deque[Integer] deque = new LinkedList<>();
     * 1. 利用deque.push(i)存储元素；
     * 2. 利用deque.peek()对应的温度跟当前温度对比
     * 3. 利用deque.pop() 将当前队列的元素出队
     * 核心的一点是存储温度的下标，用来比较差距时可以通过当前的下标和队列的下标比较计算差距
     * 缺漏点：初始化数组操作 int[] ans = new int[length];
     *          给差距数组ans赋值时，要注意下标是当时温度的数组，即打输的那个的下标，ans[di] = i = di;
     * @param temperatures
     * @return
     */
    public int[] dailyTemperature(int[] temperatures) {
        int length = temperatures.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[length];
        for (int i =0;i<length;i++) {
            int temperature = temperatures[i];
            while(!deque.isEmpty() && temperature > temperatures[deque.peek()]) {
                Integer preIndex = deque.pop();
                ans[preIndex] = i - preIndex;
            }
            deque.push(i);
        }
        return ans;
    }



    public int[] dailyTem(int[] tems) {
        int length = tems.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[length];
        for(int i = 0;i<length;i++) {
            int t = tems[i];
            while(!deque.isEmpty() && t > tems[deque.peek()]) {
                Integer di = deque.pop();
                ans[di] = i - di;
            }
            deque.push(i);
        }
        return ans;
    }

    public int[] dailyTemplature(int[] temperatures) {
        int length = temperatures.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while(!deque.isEmpty() && temperature > temperatures[deque.peek()]) {
                Integer preIndex = deque.pop();
                ans[preIndex] = i - preIndex;
            }
            deque.push(i);
        }
        return ans;
    }

}
