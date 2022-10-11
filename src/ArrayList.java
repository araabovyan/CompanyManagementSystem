import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>{
    public static final int CAPACITY = 10;
    E[] data;
    private int size = 0;

    public ArrayList(){
        this(CAPACITY);
    }

    public ArrayList(int n){
        data = (E[]) new Object[n];
    }

    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void empty() {
        data = (E[]) new Object[CAPACITY];
        size = 0;
    }

    public void print() {
        StringBuilder sb = new StringBuilder("(");
        for (int j = 0; j < size; j++) {
            if (j > 0) sb.append(", ");
            sb.append(data[j]);
        }
        sb.append(")");
        System.out.println(sb.toString());
    }

    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E answer = data[i];
        data[i] = e;
        return answer;
    }

    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
        checkIndex(i, size+1);
        if(size == data.length){
            throw new IllegalStateException("Array is full!");
        }
        for (int j = size; j > i; j--) {
            data[j] = data[j-1];
        }
        data[i] = e;
        size++;
    }

    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E answer = data[i];
        for (int k = i; k < size - 1; k++) {
            data[k] = data[k+1];
        }
        data[size - 1] = null;
        size--;
        return answer;
    }

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) throw new IndexOutOfBoundsException("Illegal index: " + i);
    }

    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public boolean removeFirst() {
        return null != remove(0);
    }

    @Override
    public void addLast(E e) {
        add(size, e);
    }

    @Override
    public boolean removeLast() {
        return null != remove(size-1);
    }

    @Override
    public E first() {
        return data[0];
    }

    @Override
    public E last() {
        return data[size-1];
    }

    @Override
    public boolean replace(E e, E r) {
        for (int i = 0; i < size; i++) {
            if(data[i] == e){
                set(i, r);
                return true;
            }
        }
        return false;
    }

    private class ArrayIterator implements Iterator<E> {
        int j = 0;
        boolean removable = false;
        public boolean hasNext(){
            return j < size;
        }

        public E next() throws NoSuchElementException {
            if(j == size) throw new NoSuchElementException("No next element!");
            removable = true;
            return data[j++];
        }

        public void remove() throws IllegalStateException {
            if (!removable) throw new IllegalStateException("nothing to remove");
            ArrayList.this.remove(j-1);
            j--;
            removable = false;
        }
    }

    private class ArrayOddIterator implements Iterator<E>{
        int j = 0;
        public boolean hasNext(){
            return j < size-1;
        }

        public E next() throws NoSuchElementException {
            if(j == size-1) throw new NoSuchElementException("No next element!");
            E answer = data[j];
            j += 2;
            return answer;
        }
    }

    public Iterator<E> oddIteratro(){
        return new ArrayOddIterator();
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }
}
