package lianbiao;

import utils.GenerateUtil;

/**
 * @author MX.Y
 * @DATE 2022-05-28 9:40
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        boolean flag = true;
        int length = 0;
        ListNode cur = head;
        // 先查数量
        while(flag) {
            length ++;
            if (cur.next == null) {
                flag = false;
            }
            cur = cur.next;
        }

        int stop = length/2 + 1;
        System.out.println(stop);
        // 遍历停止
        for (int i = 1; i < stop; i++) {
            head = head.next;
        }
        return head;
    }

    /**
     * 牛逼快慢
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        int index = 0;
        while (fast.next != null) {
            if (index % 2 == 0) {
                slow = slow.next;
            }
            index++;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = GenerateUtil.getListNodeFromArray(nums);

        MiddleNode m = new MiddleNode();
        ListNode listNode = m.middleNode(head);
        GenerateUtil.printList(listNode);
    }
}