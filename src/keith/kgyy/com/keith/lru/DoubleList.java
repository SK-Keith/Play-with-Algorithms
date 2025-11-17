package kgyy.com.keith.lru;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/19 0019 14:49
 */
public class DoubleList {

    private Node head, tail;

    private Integer size;

    public DoubleList() {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = tail;
        this.tail.prev = head;
        size = 0;
    }

    public void add(Node node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    public void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size--;
    }

    public Node remove() {
        Node node = this.head.next;
        remove(node);
        return node;
    }

    public int getSize() {
        return this.size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node next = head.next;
        while(next.next != null) {
            sb.append(next.toString() + "->");
            next = next.next;
        }
        return sb.toString();
    }

}
