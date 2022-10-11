public interface Deque<T> extends Collection<T>{
    void pushFront(T value);
    void pushBack(T value);
    T popFront();
    T popBack();
    T front();
    T back();
    boolean swap(T v1, T v2);   // swaps the first occurrence of v1 in
                                //deque with the first occurrence of v2
}
