package lianbiao.LRU;

/**
 * @author MX.Y
 * @DATE 2024-03-28 0:00
 */
public class Demo {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        System.out.println(cache.toString());
        Node node = cache.get(2);
        System.out.println(node);
        cache.put(4, 4);
        System.out.println(cache.toString());
    }
}
