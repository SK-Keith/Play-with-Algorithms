package com.keith.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU算法，最近最少使用算法
 * 最近使用的数据保留，长时间未使用的数据应该淘汰
 * 使用双向链表和哈希表来维护访问顺序
 * 哈希表用于快速查找，双向链表用于维护顺序
 *
 * @author yaomianxian
 * @date 2024/12/19 0019 14:56
 */
public class LRUCache {

    public Map<Integer, Node> map;

    public DoubleList cache;

    public int length;

    public LRUCache(int length) {
        this.length = length;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public void addNode(Node node) {
        map.put(node.key, node);
        cache.add(node);
    }

    public void remove(Node node) {
        map.remove(node.key);
        cache.remove(node);
    }

    public Node remove() {
        Node remove = cache.remove();
        map.remove(remove.key);
        return remove;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if (map.containsKey(node.key)) {
            Node oldNode = map.get(node.key);
            remove(oldNode);
            addNode(node);
        } else {
            if (this.length <= cache.getSize()) {
                remove();
            }
            addNode(node);
        }
    }

    public Node get(int key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node node = map.get(key);
        remove(node);
        addNode(node);
        return node;
    }

    public String toString() {
        return cache.toString();
    }
}
