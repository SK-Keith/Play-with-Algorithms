package kgyy.com.keith.huadong;

public class EqualSubstring {

	// 花费最多maxCost能够尽量使s转化为t
	public int equalSubString(String s, String t, int maxCost) {
		int left = 0, right = 0;
		// 花费
		int cost = 0;
		// 记录此时窗口的大小
		int res = 0;
		while(right < s.length()) {
			// 所需成本
			cost += Math.abs(s.charAt(right) - t.charAt(right));
			// 右指针一直移动到s的结尾
			right++;
			while (cost > maxCost) {
				cost -= Math.abs(s.charAt(left) - t.charAt(left));
				left ++;
			}
			// 记录此时窗口的大小
			res = Math.max(res, right - left);
		}
		return res;
	}


}
