package lianbiao;

import utils.GenerateUtil;

/**
 * @author MX.Y
 * @DATE 2022-05-28 13:39
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode tmp = head;
        // 1. 求长度
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        // 2. 如果删除的元素下标等于元素个数时，即删除第一个元素
        if (size == n) {
            head = head.next;
        } else {
            // 3. 删除倒数第n个，求出正的位置
            n = size - 1 - n;
            ListNode pre = head, cur = head;
            // 4. 删除第n个元素的操作
            for (int i = 0; i <= n; i++) {
                if (i == n) {
                    pre.next = cur.next.next;
                } else {
                    pre = cur.next;
                }
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int traverse = traverse(head, n);
        if (traverse == n)
            return head.next;
        return head;
    }

    private int traverse(ListNode node, int n) {
        if (node == null)
            return 0;
        int num = traverse(node.next, n);
        if (num == n)
            node.next = node.next.next;
        return num + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
//        int[] nums = new int[]{1};
        ListNode head = GenerateUtil.getListNodeFromArray(nums);

        RemoveNthFromEnd r = new RemoveNthFromEnd();
        ListNode listNode = r.removeNthFromEnd2(head, 1);
        GenerateUtil.printList(listNode);
    }

}
