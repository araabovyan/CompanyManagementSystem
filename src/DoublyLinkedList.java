public class DoublyLinkedList<E> implements List<E>{
    private static class Node<E>{
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E e) {
            element = e;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void empty() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
        size = 0;
    }

    public E first(){
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    public E last(){
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    @Override
    public boolean replace(E e, E r) {
        if(isEmpty()) return false;
        Node<E> walk = header.getNext();
        while(walk != null){
            if(walk.getElement() == e){
                walk.setElement(e);
                return true;
            }
            walk = walk.getNext();
        }
        return false;
    }

    public void addFirst(E e){
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e){
        addBetween(e, trailer.getPrev(), trailer);
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    public boolean removeFirst(){
        if (isEmpty()) return false;
        remove(header.getNext());
        return true;
    }

    public boolean removeLast(){
        if (isEmpty()) return false;
        remove(trailer.getPrev());
        return true;
    }

    private E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = header.getNext();
        while (walk != trailer) {
            sb.append(walk.getElement());
            walk = walk.getNext();
            if (walk != trailer)
                sb.append(", ");
        }
        sb.append(")");
        System.out.println(sb.toString());
    }
}
