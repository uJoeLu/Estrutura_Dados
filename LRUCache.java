import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private int capacity;
    private Map<K, V> cache;
    private DoublyLinkedList<K> lruList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        lruList = new DoublyLinkedList<>();
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            lruList.remove(key);
        } else if (cache.size() >= capacity) {
            K lruKey = lruList.removeLast();
            cache.remove(lruKey);
        }
        cache.put(key, value);
        lruList.addFirst(key);
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            V value = cache.get(key);
            lruList.remove(key);
            lruList.addFirst(key);
            return value;
        }
        return null;
    }
}
