public interface Set<E> extends Collection<E>{
    boolean add(E value);
    boolean remove(E value);
    boolean contains(E value);
    boolean equals(Set<E> s);
}
