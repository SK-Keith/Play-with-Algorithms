package com.keith.lru;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/03/27 0027 15:17
 */
public class Demo {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        System.out.println(cache);
        cache.put(2, 2);
        System.out.println(cache);
        cache.put(3, 3);
        System.out.println(cache);
        Node node = cache.get(2);
        System.out.println(node.val);
        System.out.println(cache);
        cache.put(4, 4);
        System.out.println(cache);
    }
}
