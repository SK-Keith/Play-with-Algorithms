package com.keith.lru;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/03/28 0028 13:13
 */
public class ReverseList {

    public static Node reverse(Node head) {
        Node prev = null;
        Node cur = head;
        while(cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static Node reverse2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node node = reverse2(head.next);

        head.next.next = head;
        head.next = null;

        return node;
    }

    public static void main(String[] args) {
        // 创建一个简单的链表：1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // 输出原始链表
        System.out.println("原始链表：");
        printLinkedList(head);

        // 使用 reverse 方法反转链表
        Node reversedHead = reverse2(head);

        // 输出反转后的链表
        System.out.println("反转后的链表：");
        printLinkedList(reversedHead);
    }

    // 输出链表的方法
    public static void printLinkedList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }
}
