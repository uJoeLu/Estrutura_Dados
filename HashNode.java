import java.util.LinkedList;

class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class HashTable<K, V> {
    private static final int SIZE = 16;
    private LinkedList<HashNode<K, V>>[] buckets;

    public HashTable() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public void put(K key, V value) {
        int index = getHash(key);
        LinkedList<HashNode<K, V>> bucket = buckets[index];
        for (HashNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        bucket.add(new HashNode<>(key, value));
    }

    public V get(K key) {
        int index = getHash(key);
        LinkedList<HashNode<K, V>> bucket = buckets[index];
        for (HashNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getHash(key);
        LinkedList<HashNode<K, V>> bucket = buckets[index];
        HashNode<K, V> toRemove = null;
        for (HashNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                toRemove = node;
                break;
            }
        }
        if (toRemove != null) {
            bucket.remove(toRemove);
        }
    }
}
