package shuangzhizhen;

import java.util.List;

/**
 * @author MX.Y
 * @DATE 2022-04-09 11:34
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;

        while(cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while(cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;

//
//        ListNode dump = head;
//        ListNode midd = new ListNode();
//        while(head.next != null) {
//            int tmp = head.val;
//            ListNode next = head.next;
//            if (next.val != tmp) {
//                // 相等时，拼接上
//                midd = dump;
//                dump = new ListNode(head.val);
//                dump.next = midd;
//            } else {
//                // 进行下一个节点
//            }
//            head = head.next;
//        }

    }

    public static void main(String[] args) {
        ListNode n7 = new ListNode(5);
        ListNode n6 = new ListNode(4, n7);
        ListNode n5 = new ListNode(4, n6);
        ListNode n4 = new ListNode(3, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(1, n3);
        ListNode n1 = new ListNode(1, n2);

//        while(n1.next != null) {
//            System.out.print(n1.val + "->");
//            n1 = n1.next;
//        }
//        System.out.println(n1.val);

        DeleteDuplicates d = new DeleteDuplicates();
        ListNode node = d.deleteDuplicates(n1);

        while(node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println(node.val);
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
