package lianbiao.LRU;

import java.util.HashMap;

/**
 * @author MX.Y
 * @DATE 2024-03-26 23:54
 */
public class LRUCache {
    // key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1,v1) <-> Node(k2,v2)...
    private DoubleList cache;
    // 最大容量
    private int cap;

    public LRUCache(int cap) {
        this.cap = cap;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    // 将某个key提升为最近使用
    private void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    // 添加最近使用的元素
    private void addRecently(int key, int val) {
        Node node = new Node(key, val);
        cache.addLast(node);
        map.put(key, node);
    }

    // 删除某一个key
    private void deleteKey(int key) {
        Node node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    private void removeLeastRecently() {
        Node deleteNode = cache.removeFirst();
        int oldKey = deleteNode.key;
        map.remove(oldKey);
    }
}
