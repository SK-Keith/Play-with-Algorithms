package lianbiao;

import com.google.common.collect.Lists;

/**
 * 双指针迭代、
 * https://leetcode.cn/problems/reverse-linked-list/
 * @author MX.Y
 * @DATE 2022-12-01 10:52
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode head = NodeHelper.insert(Lists.newArrayList(1, 2, 3, 4));
        ListNode listNode = reverseList2(head);
        NodeHelper.print(listNode);
    }

    /**
     * 迭代
     * @param head
     * @return
     */
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    private static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }


//    public static ListNode reverseList(ListNode head) {
//        ListNode reNode = new ListNode(-1);
//        ListNode cur = getLast(head);
//        while(head != null) {
//            reNode.val = cur.val;
//            reNode.next = reNode;
//            reNode = reNode.next;
//            cur = getLast(head);
//        }
//        return reNode;
//    }
//
//    public static ListNode getLast(ListNode node) {
//        while (node.next != null) {
//            node = node.next;
//        }
//        return node;
//    }


}
