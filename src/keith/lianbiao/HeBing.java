package lianbiao;

import java.util.Arrays;

/**
 * @author MX.Y
 * @DATE 2022-11-30 20:46
 */
public class HeBing {
    public static void main(String[] args) {
        ListNode node1 = NodeHelper.insert(Arrays.asList(1, 2, 4));
        ListNode node2 = NodeHelper.insert(Arrays.asList(1, 3, 4));
        ListNode listNode = mergeTwoLists(node1, node2);
        NodeHelper.print(listNode);
    }

    /**
     * 合并两个链表
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(-1);
        ListNode prev = node;
        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }

            prev = prev.next;
        }
        prev.next = list1 == null ? list2 : list1;
        return node.next;
    }


}