import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K, V> {
    private int capacity;
    private Map<K, V> cache;
    private LinkedList<K> lruList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        lruList = new LinkedList<>();
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
    public void imprimirTabela() {
        for (int i = 0; i < lruList.size(); i++) {
            K key = lruList.get(i);
            V value = cache.get(key);
            System.out.println("Índice " + i + ": " + key + " = " + value);
        }
    }
}
