import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E>{
    public static final int CAPACITY = 10;
    E[] data;
    private int f = 0;
    private int size = 0;

    public ArrayDeque(){
        this(CAPACITY);
    }

    public ArrayDeque(int n){
        data = (E[]) new Object[n];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == data.length;
    }


    private void resize(int capacity){
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < size(); i++) {
            temp[i] = data[(f + i) % data.length];
        }
        f = 0;
        data = temp;
    }

    @Override
    public E front(){
        if(isEmpty()) return null;
        return data[f];
    }

    @Override
    public E back(){
        if(isEmpty()) return null;
        return data[(f + size - 1) % data.length];
    }

    @Override
    public void pushBack(E e) {
        if(isFull()) {
            resize(2 * data.length);
        }
        data[(f + size)% data.length] = e;
        size++;
    }

    @Override
    public void pushFront(E e){
        if(isFull()) resize(2 * data.length);
        if(f > 0){
            f--;
        }else{
            f = data.length - 1;
        }
        data[f] = e;
        size++;
    }

    @Override
    public E popFront() {
        if(isEmpty()) return null;
        E answer = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        size--;
        return answer;
    }

    @Override
    public E popBack() {
        if(isEmpty()) return null;
        E answer = data[(f + size - 1) % data.length];
        data[(f + size - 1) % data.length] = null;
        size--;
        return answer;
    }

    @Override
    public void empty() {
        data = (E[]) new Object[CAPACITY];
        size = 0;
        f = 0;
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder("(");
        for (int j = 0; j < size; j++) {
            if (j > 0) sb.append(", ");
            sb.append(data[(f + j) % data.length]);
        }
        sb.append(")");
        System.out.println(sb.toString());
    }

    @Override
    public boolean swap(E v1, E v2) {
        for (int j = 0; j < size; j++) {
            if (data[(f + j) % data.length] == v1) {
                data[(f + j) % data.length] = v2;
                return true;
            }
        }
        return false;
    }

    private class ArrayDequeIterator<E> implements Iterator<E>{
        private int count = 0;
        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public E next() {
            E answer = (E) data[(f + count) % data.length];
            count++;
            return answer;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayDequeIterator<E>();
    }
}
