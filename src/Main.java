public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.addLast("d");
        list.addLast("e");
        list.print();
        reverse(list);
        list.print();

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
