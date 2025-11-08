package com.keith.merge;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/04/1 0001 19:20
 */
public class MergeTwoLists2 {

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
