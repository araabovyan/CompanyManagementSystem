public interface List<T> extends Collection<T> {
    void addFirst(T e);
    boolean removeFirst();
    void addLast(T e);
    boolean removeLast();
    T first();
    T last();
    boolean replace(T e, T r);
}
