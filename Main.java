public class Main {
    public static void main(String[] args) {
        // Testando a HashTable
        System.out.println("Testando HashTable...");
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("key1", "value1");
        hashTable.put("key2", "value2");
        hashTable.put("key3", "value3");

        System.out.println("Get key1: " + hashTable.get("key1")); // Output: value1
        System.out.println("Get key2: " + hashTable.get("key2")); // Output: value2

        hashTable.remove("key2");
        System.out.println("Get key2 apos remocao: " + hashTable.get("key2")); // Output: null

        // Testando a LRUCache
        System.out.println("\nTestando LRUCache...");
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);
        lruCache.put(1, "one");
        lruCache.put(2, "two");
        lruCache.put(3, "three");

        System.out.println("Get 1: " + lruCache.get(1)); // Output: one
        lruCache.put(4, "four"); // Este put deve remover o item mais antigo (key 2)

        System.out.println("Get 2: " + lruCache.get(2)); // Output: null
        System.out.println("Get 3: " + lruCache.get(3)); // Output: three
        System.out.println("Get 4: " + lruCache.get(4)); // Output: four

        lruCache.put(5, "five"); // Este put deve remover o item mais antigo (key 1)
        System.out.println("Get 1: " + lruCache.get(1)); // Output: null
        System.out.println("Get 5: " + lruCache.get(5)); // Output: five
    }
}
