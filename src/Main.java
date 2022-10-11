import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<String> d = new ArrayDeque<>();
        d.pushFront("a");
        d.pushBack("b");
        d.pushFront("c");
        d.pushFront("d");
        d.print();
        Iterator<String> i = d.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
//        list.print();
//        reverse(list);
//        list.print();

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
