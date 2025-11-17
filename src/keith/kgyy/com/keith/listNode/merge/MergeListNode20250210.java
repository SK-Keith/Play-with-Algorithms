package kgyy.com.keith.listNode.merge;

import kgyy.com.keith.listNode.ListNode;

public class MergeListNode20250210 {

	public static Node merge(Node l1, Node l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}


	public static Node merge2(Node l1, Node l2) {
		Node preHead = new Node(-1);
		Node pre = preHead;
		while(l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				preHead.next = l1;
				l1 = l1.next;
			} else {
				preHead.next = l2;
				l2 = l2.next;
			}
			preHead = preHead.next;
		}
		preHead.next = l1 == null ? l2 : l1;
		return pre.next;
	}
}
