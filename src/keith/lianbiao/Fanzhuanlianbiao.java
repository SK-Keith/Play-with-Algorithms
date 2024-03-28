package lianbiao;

/**
 * @author MX.Y
 * @DATE 2022-05-06 7:14
 */
public class Fanzhuanlianbiao {

    public static void main(String[] args) {

    }

    private ListNode getListNode(int[] arrs) {
        if (arrs.length <= 0) {
            return null;
        }
        ListNode head = new ListNode(arrs[0], null);
        for (int i = 1; i < arrs.length; i++) {
            ListNode next = new ListNode(arrs[i], null);
            head.setNext(next);
            head = head.getNext();
        }
        return head;
    }




}
