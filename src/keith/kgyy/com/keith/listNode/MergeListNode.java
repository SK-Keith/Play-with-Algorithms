package kgyy.com.keith.listNode;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/solutions/226408/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/?envType=study-plan-v2&envId=selected-coding-interview
 *
 * @author yaomianxian
 * @date 2024/08/6 0006 19:16
 */
public class MergeListNode {
    /**
     * 递归合并，如果l1的值小于l2，
     *  就递归地合并l1.next和l2
     *  将l1.next指向合并后的解雇
     *  返回l1作为当前的头结点
     * 否则：
     *  递归地合并l1和l2.next
     *  将l2.next指向合并后的结果
     *  返回l2作为当前的头结点
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    /**
     * 使用迭代合并两个有序链表
     * 1. 初始化一个哑结点preHead
     * 2. 初始化一个指针prev，指向preHead
     * 3. 遍历链表l1,l2,直到其中一个为空
     *  循环中比较l1,l2，
     *  如果l1小于l2，则prev下一个节点指向l1,即prev.next = l1，并将l1向后移动一个节点
     *  如果l2小于l1,...
     *  每次操作后都将prev向后移动一个节点
     * 4. 处理剩下的节点，哪个为空就指向另一个非空的
     * 5. 最后返回合并后的链表的头结点preHead.next
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode merge2(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating first linked list: 1 -> 3 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // Creating second linked list: 2 -> 4 -> 6
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        // Merging the two linked lists
        ListNode mergedList = merge2(l1, l2);

        // Printing the merged linked list
        System.out.print("Merged Linked List: ");
        printList(mergedList);
    }
}
