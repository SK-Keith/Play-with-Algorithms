package kgyy.com.keith.lru;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/5 0005 14:24
 */
public class DoubleList2 {

    private Node2 head, tail;

    private int size;

    public DoubleList2() {
        this.head = new Node2(0, 0);
        this.tail = new Node2(0, 0);
        this.head.next = tail;
        this.tail.prev = head;
        size = 0;
    }

    public void addNode(Node2 node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        size+=1;
    }

    public void deleteNode(Node2 node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size-=1;
    }

    public Node2 remove() {
        Node2 node = head.next;
        deleteNode(node);
        return node;
    }

    public int getSize() {
        return this.size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node2 next = head.next;
        while(next.next != null) {
            sb.append(next.key).append(":").append(next.value).append("->");
            next = next.next;
        }
        return sb.toString();
    }
}
