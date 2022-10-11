import java.util.Iterator;

public class LinkedList<E> implements List<E>, Iterable<E>{
    private static class Node<E>{
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E e){
            element = e;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public LinkedList(){}

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void empty() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E first(){
        if(isEmpty()) return null;
        return head.getElement();
    }

    @Override
    public E last(){
        if(isEmpty()) return null;
        return tail.getElement();
    }

    @Override
    public boolean replace(E e, E r) {
        if(isEmpty()) return false;
        Node<E> walk = head;
        while(walk != null){
            if(walk.getElement() == e){
                walk.setElement(e);
                return true;
            }
            walk = walk.getNext();
        }
        return false;
    }

    @Override
    public void addFirst(E e){
        head = new Node<>(e, head);
        if(isEmpty()) tail = head;
        size++;
    }
    @Override
    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if(isEmpty()){
            head = newest;
        }else{
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    @Override
    public boolean removeLast() {
        if(isEmpty()){
            return false;
        }
        Node<E> walk = head;
        while(walk.getNext() == tail){
            walk = walk.getNext();
            }
        walk.setNext(null);
        tail = walk;
        size--;
        return false;
    }

    public boolean removeFirst(){
        if(isEmpty()){
            return false;
        }
        head = head.getNext();
        size--;
        if(isEmpty()){
            tail = null;
        }
        return true;
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
            walk = walk.getNext();
        }
        sb.append(")");
        System.out.println(sb.toString());
    }

    private class LinkedIterator implements Iterator<E>{
        Node<E> walk = head;
        Node<E> prev = null;
        @Override
        public boolean hasNext() {
            return walk != null;
        }

        @Override
        public E next() {
            E answer = walk.getElement();
            walk = walk.getNext();
            return answer;
        }
    }

    private class OddLinkedIterator implements Iterator<E>{
        Node<E> walk = head;
        @Override
        public boolean hasNext() {
            return walk != null;
        }

        @Override
        public E next() {
            E answer = walk.getElement();
            walk = walk.getNext();
            if(walk != null){
                walk = walk.getNext();
            }
            return answer;
        }
    }

    public Iterator<E> oddIterator(){
        return new OddLinkedIterator();
    }


    @Override
    public Iterator<E> iterator() {
        return new LinkedIterator();
    }

}
