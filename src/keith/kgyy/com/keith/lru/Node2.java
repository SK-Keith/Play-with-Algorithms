package kgyy.com.keith.lru;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/5 0005 14:22
 */
public class Node2 {
    public Integer key, value;

    public Node2 prev, next;

    public Node2(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
