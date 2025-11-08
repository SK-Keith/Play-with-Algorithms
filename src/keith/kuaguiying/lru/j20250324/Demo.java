package com.keith.lru.j20250324;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/04/9 0009 14:06
 */
public class Demo {

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        System.out.println(cache);
        cache.put(2, 22);
        Node<Integer, Integer> node = cache.get(2);
        System.out.println(node);
        cache.put(4, 4);
        System.out.println(cache);

    }

}
