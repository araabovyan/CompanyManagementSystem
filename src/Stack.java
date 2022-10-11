public interface Stack<T> extends Collection<T> {
    void push(T e);
    T pop();
    T top();
}