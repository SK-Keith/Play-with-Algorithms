package kgyy.com.keith.listNode.youhuan;

import kgyy.com.keith.listNode.ListNode;

public class Youhuan260130 {

	public ListNode cycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		// 1. 先证明链表是有环的
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break;
			}
		}

		if (fast == null || fast.next == null) {
			return null;
		}

		slow = head;

		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}
}
