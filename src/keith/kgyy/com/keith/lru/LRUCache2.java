package kgyy.com.keith.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/12/5 0005 14:42
 */
public class LRUCache2 {

    public DoubleList2 cache;

    public Map<Integer, Node2> map;

    public int size;

    public LRUCache2(int size) {
        this.map = new HashMap<>();
        this.cache = new DoubleList2();
        this.size = size;
    }

    public void add(Node2 node) {
        cache.addNode(node);
        map.put(node.key, node);
    }

    public void delete(Node2 node) {
        cache.deleteNode(node);
        map.remove(node.key);
    }

    public Node2 remove() {
        Node2 remove = cache.remove();
        map.remove(remove.key);
        return remove;
    }

    public void put(int key, int value) {
        Node2 node2 = new Node2(key, value);
        if (map.containsKey(key)) {
            Node2 node = map.get(key);
            delete(node);
            add(node2);
        } else {
            if (cache.getSize() >= size) {
                remove();
            }
            add(node2);
        }
    }

    public Node2 get(int key) {
        if (!map.containsKey(key)) {
            return null;
        }

        Node2 node2 = map.get(key);
        delete(node2);
        add(node2);
        return node2;
    }

    public String toString() {
        return this.cache.toString();
    }
}
