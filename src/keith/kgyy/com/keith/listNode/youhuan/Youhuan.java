package kgyy.com.keith.listNode.youhuan;

import kgyy.com.keith.listNode.ListNode;

public class Youhuan {

	public ListNode cycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while(fast != null && fast.next != null) {
			// 慢指针每次走一步
			slow = slow.next;
			// 快指针每次走两步
			fast = fast.next.next;

			if (slow == fast) {
				// 说明有环
				break;
			}
		}
		// 如果fast为null 或fast.next 为null，则说明无环
		if (fast == null || fast.next == null) {
			return null;
		}

		slow = head;
		// 两个指针每次各走一步，相遇则为环入口
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		// 或fast,两者相遇即为环入口
		return slow;
	}
}
