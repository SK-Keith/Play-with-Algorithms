package lianbiao.LRU;

/**
 * @author MX.Y
 * @DATE 2024-03-26 23:43
 */
public class Node {
    public int key, val;

    public Node next, prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString() {
        return this.key + ":" + this.val;
    }
}
