package com.keith.lru;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/03/27 0027 14:40
 */
public class DoubleList {

    private Node head, tail;

    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addLast(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        // 新节点是添加到尾节点，而非头结点
//        node.prev = head;
//        node.next = head.next;
        // 顺序一改，链表断裂！！！
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    public int getSize() {
        return size;
    }

    // 重写toString方法
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = head.next;
        while (curr != tail) {
            sb.append("(").append(curr.key).append(", ").append(curr.val).append(") -> ");
            curr = curr.next;
        }
        return sb.toString();
    }
}
