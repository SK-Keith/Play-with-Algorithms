package com.keith.lru.j20250324;


import java.util.HashMap;
import java.util.Map;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2025/03/24 0024 13:57
 */
public class LRUCache<k, v> {

    private int capacity;

    public int count;

    private Map<k, Node<k, v>> map;

    private Node<k, v> head;

    private Node<k, v> tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<k, Node<k, v>>();
        this.capacity = capacity;

        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;

        this.head = head;
        this.tail = tail;
    }

    public void put(k key, v value) {
        Node<k, v> node = map.get(key);
        if (node == null) {
            if (count >= capacity) {
                // 删除节点
                removeNode();
            }
            node = new Node<k, v>(key, value);
            addNode(node);
        } else {
            // 修复问题！！！
            node.value =value;
            moveNodeToHead(node);
        }
    }

    public Node<k, v> get(k key) {
        Node<k, v> node = map.get(key);
        if (node == null) {
            return null;
        } else {
            moveNodeToHead(node);
        }
        return node;
    }

    public void removeNode() {
        Node<k, v> prev = tail.prev;
        removeFromList(prev);
        count--;
        map.remove(prev.key);
    }

    public void removeFromList(Node<k, v> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // 这一步之前没有
        node.next = null;
        node.prev = null;
    }


    public void addNode(Node<k, v> node) {
        addToHead(node);
        count++;
        map.put(node.key, node);
    }

    public void addToHead(Node<k, v> node) {
        // 顺序！
        Node next = head.next;
        next.prev = node;
        node.prev = head;
        node.next = next;
        head.next = node;
    }

    public void moveNodeToHead(Node<k, v> node) {
        removeFromList(node);
        addToHead(node);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node<k, v> node = head.next; node != tail; node = node.next) {
            sb.append(node.toString());
            sb.append(",");
        }
        return sb.toString();
    }
}
