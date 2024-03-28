package lianbiao;

import java.util.List;

/**
 * @author MX.Y
 * @DATE 2022-11-30 21:01
 */
public class NodeHelper {

    public static ListNode insert(List<Integer> val){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (Integer v : val) {
            ListNode next = new ListNode(v);
            cur.next = next;
            cur = cur.next;
        }
        return head.next;
    }

    public static void print(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while(node != null) {
            sb.append(node.val).append("  ");
            node = node.next;
        }
        System.out.println(sb.toString());
    }
}
