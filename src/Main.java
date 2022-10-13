import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        testDequeMethods("Array");
        testDequeMethods("LinkedList");
    }

    private static <E> void testDequeMethods(String dequeType) {
        System.out.println("Running Deque methods tests for " + dequeType );
        testIsEmpty(dequeType);
        testFront(dequeType);
        testBack(dequeType);

        System.out.println();
    }

    public static void testIsEmpty(String dequeType){
        Deque<String> deque = initializeDeque(dequeType);

        if(deque.isEmpty() == true){
            System.out.println("PASS: isEmpty()");
        }else{
            System.out.println("FAIL: isEmpty()");
        }
    }

    public static void testFrontAndPushFront(String dequeType){
        Deque<String> deque = initializeDeque(dequeType);
        deque.pushFront("a");
        deque.pushFront("b");

        if(deque.front() == "b"){
            System.out.println("PASS: front and pushFront()");
        }else{
            System.out.println("FAIL: front and pushFront()");
        }
    }

    public static void testFront(String dequeType){
        Deque<String> deque = initializeDeque(dequeType);
        deque.pushFront("a");
        deque.pushFront("b");

        if(deque.front() == "b"){
            deque.popFront();
            if (deque.front() == "a"){
                System.out.println("PASS: front and pushFront(), popFront");
                return;
            }
        }
        System.out.println("FAIL: front and pushFront(), popFront");
    }

    public static void testBack(String dequeType){
        Deque<String> deque = initializeDeque(dequeType);
        deque.pushBack("a");
        deque.pushBack("b");

        if(deque.back() == "b"){
            deque.popBack();
            if (deque.back() == "a"){
                System.out.println("PASS: back and pushBack(), popBack");
                return;
            }
        }
        System.out.println("FAIL: front and pushBack(), popBack");
    }

    public static Deque<String> initializeDeque(String dequeType){
        Deque<String> deque = null;
        if(dequeType == "Array") {
            deque = new ArrayDeque<>();
        }else if (dequeType == "LinkedList"){
            deque = new DoublyLinkedListDeque<>();
        }
        return deque;
    }

    public static <E> void reverse(List<E> l){
        if(l.isEmpty()){
            return;
        }
        E elem = l.last();
        l.removeLast();
        reverse(l);
        l.addFirst(elem);
    }
}
