package Collections;
public interface Collection<E> extends Iterable<E> {
    public void add(E e);
    public boolean remove(E e);
    public int size();
    public boolean isEmpty();
    public void clear();
    public boolean contains(E e);
}
