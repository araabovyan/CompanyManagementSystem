import java.util.Iterator;

public class HashSet<E> implements Set<E> {
    private HashMap<E, E> data = new HashMap<>(17);


    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void empty() {
        data.empty();
    }

    @Override
    public void print() {
        data.print();
    }

    @Override
    public boolean add(E value) {
        data.put(value, null);
        return true;
    }

    @Override
    public boolean remove(E value) {
        E v = data.remove(value);
        if(v != null)
            return true;
        return false;
    }

    @Override
    public boolean contains(E value) {
        for(E k : data.keySet()){
            if(value.equals(k)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Set<E> s) {
        for(E k : data.keySet()){
            if(!s.contains(k)){
                return false;
            }
        }
        if(s.size() != this.size())
            return false;
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }
}