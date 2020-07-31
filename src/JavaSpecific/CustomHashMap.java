package JavaSpecific;

public class CustomHashMap<K, V> {

    private final int INITIAL_SIZE = 16;

    private Entry<K, V> table[];
    private int capacity = INITIAL_SIZE;

    public CustomHashMap() {
        this.table = new Entry[capacity];
    }

    public void put(K key, V value) {
        if (key == null) return;

        int idx = hash(key);

        Entry<K, V> newentry = new Entry<K, V>(key, value, null);

        if (table[idx] == null) {
            table[idx] = newentry;
        } else {

            Entry<K, V> prev = null, cur = table[idx];

            while (cur != null) {
                if (cur.key.equals(key)) {
                    if (prev == null) {
                        newentry.next = cur.next;
                        table[idx] = newentry;
                        return;
                    } else {
                        newentry.next = cur.next;
                        prev.next = newentry;
                        return;
                    }
                }
                prev = cur;
                cur = cur.next;
            }
            prev.next = newentry;
        }
    }

    public V get(K key) {
        int idx = hash(key);

        if (table[idx] == null) return null;

        Entry<K, V> prev = null, cur = table[idx];

        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    public boolean remove(K key) {
        int idx = hash(key);

        if (table[idx] == null) return false;

        Entry<K, V> prev = null, cur = table[idx];

        while (cur != null) {
            if (cur.key.equals(key)) {
                if (prev == null) {
                    table[idx] = table[idx].next;
                    return true;
                } else {
                    prev.next = cur.next;
                    return true;
                }
            }
            prev = cur;
            cur = cur.next;
        }

        return false;
    }

    private int hash(K key) {
        return (key.hashCode() & (capacity - 1));
    }


    public void display() {
        for (Entry<K, V> entry : table) {
            if (entry == null) continue;
            Entry<K, V> cur = entry;
            while (cur != null) {
                System.out.print("[" + cur.key + "," + cur.value + "] ");
                cur = cur.next;
            }
        } System.out.println();
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
