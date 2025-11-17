package kgyy.com.keith.lru.j20250324;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/03/24 0024 14:01
 */
public class Node<k, v> {
    k key;
    v value;

    Node prev;

    Node next;
    public Node(k key, v value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
