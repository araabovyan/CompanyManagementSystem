import java.util.Iterator;

public class HashMap<K,V> extends AbstractHashMap<K,V>{
    private UnsortedTableMap<K,V>[ ] table; // initialized within createTable public ChainHashMap( ) { super( ); }
    public HashMap(int cap) { super(cap); }
    public HashMap(int cap, int p) { super(cap, p); }

    protected void createTable( ) {
        table = (UnsortedTableMap<K,V>[ ]) new UnsortedTableMap[capacity]; }

    protected V bucketGet(int h, K k) {
        UnsortedTableMap<K,V> bucket = table[h]; if (bucket == null) return null;
        return bucket.get(k);
    }

    protected V bucketPut(int h, K k, V v) {
        UnsortedTableMap<K,V> bucket = table[h]; if (bucket == null)
            bucket = table[h] = new UnsortedTableMap<>();
        int oldSize = bucket.size( );
        V answer = bucket.put(k,v);
        n += (bucket.size() - oldSize); // size may have increased
        return answer;
    }

    protected V bucketRemove(int h, K k) {
        UnsortedTableMap<K,V> bucket = table[h]; if (bucket == null) return null;
        int oldSize = bucket.size( );
        V answer = bucket.remove(k);
        n -= (oldSize - bucket.size());
        return answer;
    }

    public Iterable<Entry<K,V>> entrySet( ) {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        for (int h=0; h < capacity; h++)
            if (table[h] != null)
                for (Entry<K,V> entry : table[h].entrySet())
                    buffer.add(entry);
        return buffer;
    }

    @Override
    public void empty() {
        return;
    }

    @Override
    public void print() {
        return;
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }
}