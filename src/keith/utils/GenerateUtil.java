package utils;

import lianbiao.ListNode;

/**
 * @author MX.Y
 * @DATE 2022-05-28 13:41
 */
public class GenerateUtil {

    public static ListNode getListNodeFromArray(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 0; i < nums.length; i++) {
            ListNode next = new ListNode(nums[i]);
            cur.next = next;
            cur = cur.next;
        }
        return head.next;
    }

    public static String printList(ListNode listNode) {
        StringBuilder str = new StringBuilder();
        while(listNode != null && listNode.val != 0) {
            str.append(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(str);
        return str.toString();
    }

    public static ListNode removeListNode(ListNode head, int data) {
        ListNode pre = head, cur = head;
        while(cur != null) {
            if (cur.val == data) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static ListNode reverseList(ListNode head) {
        // 反转后的链表
        ListNode prev = null;
        // 当前链表，不断地减少第一个元素
        ListNode curr = head;
        while(curr != null) {
            // 减少第一个元素，放在next节点
            ListNode next = curr.next;
            // 构造反转后的"一个"节点
            curr.next = prev;
            // 反转链表 = 构造好的节点
            prev = curr;
            // 当前链表减少第一个元素
            curr = next;
        }
        // 返回反转后的链表
        return prev;
    }

//    private static ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode cur = head;
//        while(cur != null) {
//            // 下一个节点
//            ListNode next = cur.next;
//            // 构造新节点
//            cur.next = prev;
//            // 赋值prev
//            prev = cur;
//            // 赋值下一个节点
//            cur = next;
//        }
//        return prev;
//    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        ListNode head = getListNodeFromArray(nums);
        ListNode listNode = removeListNode(head, 2);
        printList(listNode);
    }
}
