package kgyy.com.keith.deque;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTem20250303 {

	public int[] dailyTem(int[] nums) {
		int length = nums.length;
		int[] res = new int[length];
		Deque<Integer> deque = new LinkedList();
		for(int i = 0;i<nums.length;i++) {
			int t = nums[i];
			while(!deque.isEmpty() && t > nums[deque.peek()]) {
				int last = deque.pop();
				res[last] = i - last;
			}
			deque.push(i);
		}
		return res;
	}
}
