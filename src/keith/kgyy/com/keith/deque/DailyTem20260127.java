package kgyy.com.keith.deque;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTem20260127 {

	public int[] dailyTem(int[] nums){
		int n = nums.length;
		int[] result = new int[n];
		Deque<Integer> deque = new LinkedList();
		for(int i = 0; i < n;i++) {
			int t = nums[i];
			while(!deque.isEmpty() && t > nums[deque.peek()]) {
				int last = deque.pop();
				result[last] = i - last;
			}
			deque.push(i);
		}
		return result;
	}
}


