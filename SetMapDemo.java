import java.util.*;

public class SetMapDemo {

    public static void main(String[] args) {
        section("1. SET INTERFACE");
        setDemo();

        section("2. MAP INTERFACE");
        mapDemo();

        section("3. equals() + hashCode() KYUN ZARURI HAI");
        equalsHashCodeDemo();

        section("4. HashMap INTERNAL (apna HashMap bana ke)");
        hashMapInternalDemo();

        section("5. HashSet INTERNAL (andar HashMap hi hai)");
        hashSetInternalDemo();

        section("6. TreeMap / TreeSet USAGE");
        treeMapDemo();

        section("7. TreeMap INTERNAL (apna tree bana ke)");
        treeMapInternalDemo();
    }

    static void section(String title) {
        System.out.println("\n==================== " + title + " ====================");
    }

    // =====================================================================
    // 1. SET INTERFACE  -> duplicate allowed NAHI
    // =====================================================================
    static void setDemo() {
        // HashSet: no order, fastest O(1)
        Set<String> hs = new HashSet<>();
        System.out.println(hs.add("Tally"));   // true  (naya element)
        System.out.println(hs.add("Excel"));   // true
        System.out.println(hs.add("Tally"));   // false (duplicate, ignore)
        hs.add("GST");
        hs.add(null);                          // HashSet me ek null allowed
        System.out.println("HashSet       : " + hs);

        // LinkedHashSet: insertion order maintain
        Set<String> lhs = new LinkedHashSet<>(List.of("Tally", "Excel", "GST", "Data Entry"));
        System.out.println("LinkedHashSet : " + lhs);

        // TreeSet: sorted order, O(log n), null NOT allowed
        Set<Integer> ts = new TreeSet<>(List.of(50, 10, 40, 20, 30));
        System.out.println("TreeSet       : " + ts);

        // Common methods
        System.out.println("contains(10)  : " + ts.contains(10));
        ts.remove(10);
        System.out.println("after remove  : " + ts + " size=" + ts.size());

        // Set operations (union / intersection / difference)
        Set<Integer> a = new TreeSet<>(List.of(1, 2, 3, 4));
        Set<Integer> b = new TreeSet<>(List.of(3, 4, 5, 6));

        Set<Integer> union = new TreeSet<>(a);
        union.addAll(b);
        Set<Integer> inter = new TreeSet<>(a);
        inter.retainAll(b);
        Set<Integer> diff = new TreeSet<>(a);
        diff.removeAll(b);
        System.out.println("union         : " + union);
        System.out.println("intersection  : " + inter);
        System.out.println("difference    : " + diff);

        // TreeSet extra: NavigableSet methods
        TreeSet<Integer> nums = new TreeSet<>(List.of(10, 20, 30, 40, 50));
        System.out.println("first/last    : " + nums.first() + " / " + nums.last());
        System.out.println("lower(30)     : " + nums.lower(30));     // 20  (strictly <)
        System.out.println("floor(35)     : " + nums.floor(35));     // 30  (<=)
        System.out.println("ceiling(35)   : " + nums.ceiling(35));   // 40  (>=)
        System.out.println("higher(30)    : " + nums.higher(30));    // 40  (strictly >)
        System.out.println("headSet(30)   : " + nums.headSet(30));   // < 30
        System.out.println("tailSet(30)   : " + nums.tailSet(30));   // >= 30
        System.out.println("descending    : " + nums.descendingSet());

        // Custom order: Comparator
        TreeSet<String> byLength = new TreeSet<>(Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder()));
        byLength.addAll(List.of("Excel", "GST", "Tally", "Java", "SQL"));
        System.out.println("by length     : " + byLength);
    }

    // =====================================================================
    // 2. MAP INTERFACE  -> key-value, key unique
    // =====================================================================
    static void mapDemo() {
        Map<String, Integer> hm = new HashMap<>();
        hm.put("Amit", 80);
        hm.put("Neha", 90);
        hm.put("Ravi", 70);
        System.out.println("put again (old value returned): " + hm.put("Amit", 85)); // 80
        hm.put(null, 0);                 // HashMap: ek null key allowed
        System.out.println("HashMap       : " + hm);

        System.out.println("get           : " + hm.get("Neha"));
        System.out.println("get missing   : " + hm.get("Zoya"));                // null
        System.out.println("getOrDefault  : " + hm.getOrDefault("Zoya", -1));   // -1
        System.out.println("containsKey   : " + hm.containsKey("Ravi"));
        System.out.println("containsValue : " + hm.containsValue(90));
        hm.putIfAbsent("Neha", 0);       // already hai, change nahi hoga
        hm.remove(null);

        // 3 views: keySet, values, entrySet
        System.out.println("keySet        : " + hm.keySet());
        System.out.println("values        : " + hm.values());
        for (Map.Entry<String, Integer> e : hm.entrySet()) {
            System.out.println("  " + e.getKey() + " -> " + e.getValue());
        }

        // LinkedHashMap (insertion order) & TreeMap (sorted by key)
        Map<String, Integer> lhm = new LinkedHashMap<>(hm);
        Map<String, Integer> tm = new TreeMap<>(hm);
        System.out.println("LinkedHashMap : " + lhm);
        System.out.println("TreeMap       : " + tm);

        // Real use: word count with merge()
        String text = "tally excel tally gst excel tally";
        Map<String, Integer> count = new TreeMap<>();
        for (String w : text.split(" ")) {
            count.merge(w, 1, Integer::sum);
        }
        System.out.println("word count    : " + count);

        // Real use: group karna with computeIfAbsent()
        Map<Integer, List<String>> byLen = new TreeMap<>();
        for (String w : List.of("GST", "Excel", "SQL", "Tally", "Java")) {
            byLen.computeIfAbsent(w.length(), k -> new ArrayList<>()).add(w);
        }
        System.out.println("group by len  : " + byLen);
    }

    // =====================================================================
    // 3. equals + hashCode
    // =====================================================================
    static class BadStudent {             // equals/hashCode override NAHI
        int id;
        BadStudent(int id) { this.id = id; }
    }

    static class GoodStudent {            // override kiya
        int id;
        GoodStudent(int id) { this.id = id; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof GoodStudent)) return false;
            return id == ((GoodStudent) o).id;
        }

        @Override
        public int hashCode() { return Objects.hash(id); }
    }

    static void equalsHashCodeDemo() {
        Set<BadStudent> bad = new HashSet<>();
        bad.add(new BadStudent(1));
        bad.add(new BadStudent(1));
        System.out.println("Bad  size (expected 1, got) : " + bad.size());   // 2

        Set<GoodStudent> good = new HashSet<>();
        good.add(new GoodStudent(1));
        good.add(new GoodStudent(1));
        System.out.println("Good size                   : " + good.size());  // 1

        // Rule: a.equals(b) == true  =>  a.hashCode() == b.hashCode() MUST
    }

    // =====================================================================
    // 4. HashMap INTERNAL : array of buckets + linked list chaining
    // =====================================================================
    static class MyHashMap<K, V> {

        static class Node<K, V> {
            final int hash;
            final K key;
            V value;
            Node<K, V> next;

            Node(int hash, K key, V value) {
                this.hash = hash;
                this.key = key;
                this.value = value;
            }
        }

        @SuppressWarnings("unchecked")
        Node<K, V>[] table = (Node<K, V>[]) new Node[4];   // real default = 16
        int size = 0;
        final float LOAD_FACTOR = 0.75f;                   // real default = 0.75

        // STEP 1: hash spread (upper 16 bits ko lower me mix karta hai)
        int hash(Object key) {
            if (key == null) return 0;                     // null key hamesha bucket 0
            int h = key.hashCode();
            return h ^ (h >>> 16);
        }

        // STEP 2: bucket index = (n-1) & hash   (n hamesha power of 2)
        int indexFor(int hash, int n) {
            return (n - 1) & hash;
        }

        V put(K key, V value) {
            int h = hash(key);
            int i = indexFor(h, table.length);

            if (table[i] == null) {
                table[i] = new Node<>(h, key, value);      // empty bucket
            } else {
                Node<K, V> cur = table[i];
                while (true) {
                    // STEP 3: pehle hash match, phir equals() -> same key => value replace
                    if (cur.hash == h && Objects.equals(cur.key, key)) {
                        V old = cur.value;
                        cur.value = value;
                        return old;
                    }
                    if (cur.next == null) break;
                    cur = cur.next;
                }
                cur.next = new Node<>(h, key, value);      // COLLISION: chain ke end me
                // (real Java: chain 8+ ho jaye aur table >= 64 ho to Red-Black tree ban jata hai)
            }

            // STEP 4: threshold cross => resize (double)
            if (++size > table.length * LOAD_FACTOR) {
                resize();
            }
            return null;
        }

        V get(K key) {
            int h = hash(key);
            int i = indexFor(h, table.length);
            for (Node<K, V> cur = table[i]; cur != null; cur = cur.next) {
                if (cur.hash == h && Objects.equals(cur.key, key)) return cur.value;
            }
            return null;
        }

        @SuppressWarnings("unchecked")
        void resize() {
            Node<K, V>[] old = table;
            table = (Node<K, V>[]) new Node[old.length * 2];
            System.out.println("   >>> RESIZE: " + old.length + " -> " + table.length + " (rehash)");
            for (Node<K, V> head : old) {
                for (Node<K, V> cur = head; cur != null; ) {
                    Node<K, V> next = cur.next;            // save kar lo
                    int i = indexFor(cur.hash, table.length);
                    cur.next = null;
                    if (table[i] == null) {
                        table[i] = cur;
                    } else {
                        Node<K, V> t = table[i];
                        while (t.next != null) t = t.next;
                        t.next = cur;
                    }
                    cur = next;
                }
            }
        }

        void printBuckets() {
            for (int i = 0; i < table.length; i++) {
                StringBuilder sb = new StringBuilder("   [" + i + "] ");
                for (Node<K, V> cur = table[i]; cur != null; cur = cur.next) {
                    sb.append(cur.key).append("=").append(cur.value).append(" -> ");
                }
                System.out.println(sb.append("null"));
            }
        }
    }

    static void hashMapInternalDemo() {
        MyHashMap<Integer, String> map = new MyHashMap<>();

        // Integer ka hashCode = value. capacity 4 => index = key & 3
        // 1, 5, 9, 13 sab ka index 1 aata hai => COLLISION
        int[] keys = {1, 5, 9, 13};
        for (int k : keys) {
            System.out.println("put(" + k + ")  hash=" + map.hash(k) + "  index=" + map.indexFor(map.hash(k), map.table.length));
            map.put(k, "v" + k);
            map.printBuckets();
        }

        System.out.println("get(9)  = " + map.get(9));
        System.out.println("get(99) = " + map.get(99));
        System.out.println("put(5, 'NEW') old value = " + map.put(5, "NEW"));

        // Real HashMap ka same behaviour check
        Map<String, Integer> real = new HashMap<>();
        real.put("Aa", 1);
        real.put("BB", 2);   // "Aa" aur "BB" ka hashCode SAME hai (2112) -> collision
        System.out.println("\n\"Aa\".hashCode() = " + "Aa".hashCode() + ", \"BB\".hashCode() = " + "BB".hashCode());
        System.out.println("Real HashMap dono rakhta hai (equals se alag): " + real);
    }

    // =====================================================================
    // 5. HashSet INTERNAL : HashSet = HashMap ke keys + dummy value
    // =====================================================================
    static class MyHashSet<E> {
        private final HashMap<E, Object> map = new HashMap<>();
        private static final Object PRESENT = new Object();   // dummy value

        boolean add(E e) {
            // map.put() null return kare => key pehle nahi thi => naya element
            return map.put(e, PRESENT) == null;
        }

        boolean contains(Object o) { return map.containsKey(o); }

        boolean remove(Object o) { return map.remove(o) == PRESENT; }

        int size() { return map.size(); }

        @Override
        public String toString() { return map.keySet().toString(); }
    }

    static void hashSetInternalDemo() {
        MyHashSet<String> set = new MyHashSet<>();
        System.out.println(set.add("Tally"));    // true
        System.out.println(set.add("Excel"));    // true
        System.out.println(set.add("Tally"));    // false
        System.out.println(set + "  size=" + set.size());
        System.out.println("contains Excel : " + set.contains("Excel"));
        System.out.println("remove Excel   : " + set.remove("Excel"));
        System.out.println(set);
        // Isi tarah: LinkedHashSet -> LinkedHashMap, TreeSet -> TreeMap
    }

    // =====================================================================
    // 6. TreeMap USAGE (sorted + navigation)
    // =====================================================================
    static void treeMapDemo() {
        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(50, "E");
        tm.put(10, "A");
        tm.put(30, "C");
        tm.put(20, "B");
        tm.put(40, "D");
        System.out.println("TreeMap        : " + tm);                 // key sorted
        System.out.println("firstKey       : " + tm.firstKey());
        System.out.println("lastEntry      : " + tm.lastEntry());
        System.out.println("lowerKey(30)   : " + tm.lowerKey(30));     // 20
        System.out.println("floorKey(35)   : " + tm.floorKey(35));     // 30
        System.out.println("ceilingKey(35) : " + tm.ceilingKey(35));   // 40
        System.out.println("higherKey(30)  : " + tm.higherKey(30));    // 40
        System.out.println("headMap(30)    : " + tm.headMap(30));      // keys < 30
        System.out.println("tailMap(30)    : " + tm.tailMap(30));      // keys >= 30
        System.out.println("subMap(20,40)  : " + tm.subMap(20, 40));   // 20 <= k < 40
        System.out.println("descendingMap  : " + tm.descendingMap());
        System.out.println("pollFirstEntry : " + tm.pollFirstEntry()); // remove + return
        System.out.println("after poll     : " + tm);

        // Custom comparator: reverse order
        TreeMap<String, Integer> rev = new TreeMap<>(Comparator.reverseOrder());
        rev.put("Amit", 1);
        rev.put("Zoya", 2);
        rev.put("Neha", 3);
        System.out.println("reverse TreeMap: " + rev);

        // TreeMap me null key => NullPointerException
        try {
            new TreeMap<String, Integer>().put(null, 1);
        } catch (NullPointerException e) {
            System.out.println("TreeMap null key => NullPointerException");
        }
    }

    // =====================================================================
    // 7. TreeMap INTERNAL : Binary Search Tree (real me Red-Black Tree)
    //    Left < Node < Right.  Red-Black balance rakhta hai => height O(log n)
    // =====================================================================
    static class MyTreeMap<K extends Comparable<K>, V> {

        static class Node<K, V> {
            K key;
            V value;
            Node<K, V> left, right;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        Node<K, V> root;
        int size;

        V put(K key, V value) {
            if (root == null) {
                root = new Node<>(key, value);
                size++;
                return null;
            }
            Node<K, V> cur = root;
            while (true) {
                int cmp = key.compareTo(cur.key);        // compareTo hi "equals" ka kaam karta hai
                if (cmp < 0) {
                    if (cur.left == null) { cur.left = new Node<>(key, value); size++; return null; }
                    cur = cur.left;
                } else if (cmp > 0) {
                    if (cur.right == null) { cur.right = new Node<>(key, value); size++; return null; }
                    cur = cur.right;
                } else {                                  // cmp == 0 => same key
                    V old = cur.value;
                    cur.value = value;
                    return old;
                }
            }
            // Real TreeMap yahan fixAfterInsertion() chalata hai: rotation + recolor
        }

        V get(K key) {
            Node<K, V> cur = root;
            int steps = 0;
            while (cur != null) {
                steps++;
                int cmp = key.compareTo(cur.key);
                if (cmp == 0) {
                    System.out.println("   (found in " + steps + " steps)");
                    return cur.value;
                }
                cur = (cmp < 0) ? cur.left : cur.right;  // aadha tree skip
            }
            return null;
        }

        // Inorder (Left, Node, Right) => hamesha SORTED
        void inorder(Node<K, V> n, StringBuilder sb) {
            if (n == null) return;
            inorder(n.left, sb);
            sb.append(n.key).append("=").append(n.value).append(", ");
            inorder(n.right, sb);
        }

        K firstKey() {
            Node<K, V> cur = root;
            while (cur.left != null) cur = cur.left;      // sabse left
            return cur.key;
        }

        K lastKey() {
            Node<K, V> cur = root;
            while (cur.right != null) cur = cur.right;    // sabse right
            return cur.key;
        }

        // floorKey: <= key wala sabse bada
        K floorKey(K key) {
            Node<K, V> cur = root;
            K ans = null;
            while (cur != null) {
                int cmp = key.compareTo(cur.key);
                if (cmp == 0) return cur.key;
                if (cmp < 0) cur = cur.left;
                else { ans = cur.key; cur = cur.right; }
            }
            return ans;
        }

        void print() {
            StringBuilder sb = new StringBuilder("{");
            inorder(root, sb);
            System.out.println(sb.append("}"));
        }
    }

    static void treeMapInternalDemo() {
        MyTreeMap<Integer, String> t = new MyTreeMap<>();
        //          40
        //        /    \
        //      20      60
        //     /  \    /  \
        //   10   30  50   70
        for (int k : new int[]{40, 20, 60, 10, 30, 50, 70}) {
            t.put(k, "v" + k);
        }
        t.print();                                            // sorted
        System.out.println("get(50)    = " + t.get(50));      // 40 -> 60 -> 50 : 3 steps
        System.out.println("firstKey   = " + t.firstKey());
        System.out.println("lastKey    = " + t.lastKey());
        System.out.println("floorKey(55) = " + t.floorKey(55));

        // Problem: sorted input dalo to simple BST ek line (linked list) ban jata hai
        MyTreeMap<Integer, String> skewed = new MyTreeMap<>();
        for (int i = 1; i <= 5; i++) skewed.put(i, "v" + i);
        System.out.println("Skewed tree me get(5):");
        skewed.get(5);                                        // 5 steps = O(n)
        // Isi liye real TreeMap Red-Black Tree use karta hai => hamesha O(log n)
    }
}