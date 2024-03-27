package lianbiao.LRU;

/**
 * @author MX.Y
 * @DATE 2024-03-26 23:46
 */
public class DoubleList {
    // 头尾虚节点
    private Node head, tail;
    // 链表元素数量
    private int size;

    public DoubleList() {
        // 初始化双向链表的数据
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在链表尾部添加节点x，时间O(1)
    public void addLast(Node x) {
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    // 删除链表中的X节点（X一定存在）
    // 由于是双链表且给的是目标Node节点，时间O（1）
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // 删除链表中的第一个节点，并返回该节点，时间O(1)
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

    @Override
    public String toString() {
        Node next = head.next;
        StringBuilder sb = new StringBuilder();
        while (next != null) {
            sb.append("(").append(next.key).append(":").append(next.val).append(") -> ");
            next = next.next;
        }
        return sb.toString();
    }
}
