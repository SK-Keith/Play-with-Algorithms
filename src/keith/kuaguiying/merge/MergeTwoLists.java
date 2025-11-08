package com.keith.merge;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/04/3 0003 17:02
 */
public class MergeTwoLists {

    public class ListNode {
        private int val;
        private ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(-1);
        ListNode temp = node;
        while(list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        node.next = list1 == null ? list2 : list1;
        return temp.next;
    }
}
