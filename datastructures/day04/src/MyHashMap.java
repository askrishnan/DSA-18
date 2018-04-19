import java.security.AlgorithmConstraints;
import java.util.*;

public class MyHashMap<K, V> implements Map<K, V> {

    // average number of entries per bucket before we grow the map
    private static final double ALPHA = 1.0;
    // average number of entries per bucket before we shrink the map
    private static final double BETA = .25;

    // resizing factor: (new size) = (old size) * (resize factor)
    private static final double SHRINK_FACTOR = 0.5, GROWTH_FACTOR = 2.0;

    private static final int MIN_BUCKETS = 16;

    // array of buckets
    protected LinkedList<Entry>[] buckets;
    private int size = 0;

    public MyHashMap() {
        initBuckets(MIN_BUCKETS);
    }

    public class Entry implements Map.Entry<K, V> {
        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            value = newValue;
            return value;
        }
    }

    /**
     * given a key, return the bucket where the `K, V` pair would be stored if it were in the map.
     */
    private LinkedList<Entry> chooseBucket(Object key) {
<<<<<<< HEAD
        // TODO
        // hint: use key.hashCode() to calculate the key's hashCode using its built in hash function
        // then use % to choose which bucket to return.
        int hashCode = key.hashCode();
        int length = buckets.length;
        return buckets[(hashCode % length)];

=======
        return buckets[key.hashCode() % buckets.length];
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * return true if key is in map
     */
    @Override
    public boolean containsKey(Object key) {
        // TODO
<<<<<<< HEAD
        // TODO
        Collection<K> keys  = this.keySet();
        if (keys.contains(key)) {
            return true;
=======
        LinkedList<Entry> temp = chooseBucket(key);
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getKey().equals(key)) {
                return true;
            }
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
        }
        return false;
    }

    /**
     * return true if value is in map
     */
    @Override
    public boolean containsValue(Object value) {
<<<<<<< HEAD
        // TODO
        Collection<V> values  = this.values();
        if (values.contains(value)) {
            return true;
=======
        for (int i = 0; i < buckets.length; i++) {
            LinkedList<Entry> temp = buckets[i];
            for (int j = 0; j < temp.size(); j++) {
                if (temp.get(j).getValue() == value) {
                    return true;
                }
            }
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
        }
        return false;
    }

    @Override
    // O(N/M) essentially O(1)
    public V get(Object key) {
<<<<<<< HEAD
        LinkedList<Entry> bucket = chooseBucket(key);
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).getKey().equals(key)) {
                return bucket.get(i).getValue();
            }
        }
        return null;
=======
        V value = null;
        LinkedList<Entry> temp = chooseBucket(key);
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i).getKey().equals(key)) {
                return temp.get(i).getValue();
            }
        }
        return value;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }

    /**
     * add a new key-value pair to the map. Grow if needed, according to `ALPHA`.
     * @return the value associated with the key if it was previously in the map, otherwise null.
     */
    @Override
    public V put(K key, V value) {
        // TODO: Complete this method
        V val = null;
        if (containsKey(key)) {
            val = remove(key);
        }

        LinkedList<Entry> temp = chooseBucket(key);
        Entry e = new Entry(key, value);
        temp.add(e);
        size++;
        if (size >= this.buckets.length*ALPHA) {
            rehash(GROWTH_FACTOR);
        }

        // hint: use chooseBucket() to determine which bucket to place the pair in
<<<<<<< HEAD
        // hint: use rehash() to appropriately grow the hashmap if needed
        V oldVal = null;
        int replaceIndex = 0;
        LinkedList<Entry> bucket = chooseBucket(key);
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).getKey().equals(key)) {
                oldVal = bucket.get(i).getValue();
                replaceIndex = i;
            }
        }
        if (oldVal != null) {
            bucket.get(replaceIndex).setValue(value);
        }
        else {
            Entry entry = new Entry(key, value);
            bucket.add(entry);
            size++;
        }
        if (size()/buckets.length == ALPHA) {
            rehash(GROWTH_FACTOR);
        }
        return oldVal;
=======
        // h    int: use rehash() to appropriately grow the hashmap if needed
        return val;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }

    /**
     * Remove the key-value pair associated with the given key. Shrink if needed, according to `BETA`.
     * Make sure the number of buckets doesn't go below `MIN_BUCKETS`. Do nothing if the key is not in the map.
     * @return the value associated with the key if it was in the map, otherwise null.
     */
    @Override
    public V remove(Object key) {
        // TODO
        // hint: use chooseBucket() to determine which bucket the key would be
        // hint: use rehash() to appropriately grow the hashmap if needed
<<<<<<< HEAD
        LinkedList<Entry> bucket = chooseBucket(key);
        V valGone = null;
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i).getKey().equals(key)) {
                valGone = bucket.get(i).getValue();
                bucket.remove(i);
                size--;
            }
        }
        if (buckets.length*BETA >= size() && buckets.length >= 32) {
            rehash(SHRINK_FACTOR);
        }
        return valGone;
=======
        V val = null;
        LinkedList<Entry> temp = chooseBucket(key);
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).key.equals(key)) {
                val = temp.get(i).value;
                temp.remove(i);
            }
        }
        size--;
        if (this.size <= this.buckets.length * BETA && this.buckets.length >= MIN_BUCKETS*2 ) {
            rehash(SHRINK_FACTOR);
        }
        return val;
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Changes the number of buckets and rehashes the existing entries.
     * If growthFactor is 2, the number of buckets doubles. If it is 0.25,
     * the number of buckets is divided by 4.
     */
    private void rehash(double growthFactor) {
        // TODO
        // hint: once you have removed all values from the buckets, use put(k, v) to add them back in the correct place
<<<<<<< HEAD
        LinkedList<Entry>[] oldBuckets = buckets;
        int length = buckets.length;
        Set<Map.Entry<K, V>> entries = entrySet();
        if (growthFactor == 0.5) {
            clear();
            initBuckets(length/2);
        }
        else {
            clear();
            initBuckets(length*2);
        }
        for (Map.Entry<K, V> entry : entries) {
            K key = entry.getKey();
            V val = entry.getValue();
            put(key, val);
        }
        }
=======
        size = 0;
        LinkedList<Entry>[] temp = buckets;
        int new_size = ((int)(temp.length*growthFactor));
        this.initBuckets(new_size);
        for (LinkedList<Entry> i : temp){
            for (Entry j : i) {
                put(j.getKey(), j.getValue());
            }
        }
    }
>>>>>>> a4810f1ec3eb791f82a5f3fb04c713af094b6144

    private void initBuckets(int size) {
        buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void clear() {
        initBuckets(buckets.length);
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Map.Entry<K, V> e : entrySet()) {
            keys.add(e.getKey());
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new ArrayList<>();
        for (Map.Entry<K, V> e : entrySet()) {
            values.add(e.getValue());
        }
        return values;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<Entry> map : buckets) {
            set.addAll(map);
        }
        return set;
    }
}
