package lianbiao;

import shuangzhizhen.DeleteDuplicates;

/**
 * @author MX.Y
 * @DATE 2022-04-09 15:18
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // 记录开始反转节点的前一个节点
        ListNode pre = dummy;
        for (int i = 0;i < m -1; i++) {
            pre = pre.next;
        }
        
        // 记录开始反转的节点，把后面需要反转的节点都移动到前面
        ListNode cur = pre.next;
        
        // 采用头插法，把后面的节点都插入到前面
        for(int i=0;i<n-m;i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            print(pre);
        }
        return dummy.next;
    }

    private void print(ListNode l) {
        ListNode tmp = new ListNode(l.val, l.next);
        while (tmp.next != null) {
            System.out.print(tmp.val + "->");
            tmp = tmp.next;
        }
        System.out.println(tmp.val);
    }

    private void copyListNode(ListNode l) {
        ListNode node = new ListNode(0);
        while (l.next != null) {
//            ListNode next = new ListNode(l.val);
            System.out.print(l.val + "->");
            l = l.next;
        }
//        print(node);
        System.out.println(l.next);
    }


    public static void main(String[] args) {
        ListNode n7 = new ListNode(7);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        ReverseBetween r = new ReverseBetween();

//        r.copyListNode(n1);
//        int i = 2/0;
        ListNode listNode = r.reverseBetween(n1, 0, 6);

        while (listNode.next != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }
}
