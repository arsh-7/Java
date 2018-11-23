package Collections;

public interface List<E> extends Collection<E> {
    public void add(E e);
    public boolean remove(E e);
    public E get (int index);
}
