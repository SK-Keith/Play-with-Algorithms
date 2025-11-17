package kgyy.com.keith.lru;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/19 0019 14:48
 */
public class Node {

    public Integer key, value;

    public Node prev, next;

    public Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return this.key + ":" + this.value;
    }
}
