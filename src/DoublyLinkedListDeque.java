import java.util.Iterator;

public class DoublyLinkedListDeque<E> implements Deque<E> {
    private DoublyLinkedList<E> data;
    public DoublyLinkedListDeque(){
        data = new DoublyLinkedList<>();
    }

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
    public void pushFront(E value) {
        data.addFirst(value);
    }

    @Override
    public void pushBack(E value) {
        data.addLast(value);
    }

    @Override
    public E popFront() {
        E answer = data.first();
        data.removeFirst();
        return answer;
    }

    @Override
    public E popBack() {
        E answer  = data.last();
        data.removeLast();
        return answer;
    }

    @Override
    public E front() {
        return data.first();
    }

    @Override
    public E back() {
        return data.last();
    }

    @Override
    public boolean swap(E v1, E v2) {
        return swapHelper(data, v1, v2);
    }

    private boolean swapHelper(DoublyLinkedList<E> l, E v1, E v2){
        if(v1 == l.first()){
            l.removeFirst();
            l.addFirst(v2);
            return true;
        }
        if(l.isEmpty()){
            return false;
        }
        E temp = l.first();
        l.removeFirst();
        boolean answer = swapHelper(l, v1, v2);
        l.addFirst(temp);
        return answer;
    }

    @Override
    public Iterator<E> iterator() {
        return data.iterator();
    }
}
