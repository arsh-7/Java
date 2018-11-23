package Collections;
public class Linkedlist<E> implements List<E> {
    private Node head;
    private Node tail;
    private int size;
    private class Node {
        private E data;
        private Node nn;
        Node(E e) {
            this.data=e;
            this.nn=null;
        }
    }
    public Linkedlist () {
        head=null;
        tail=null;
        size=0;
    }
    @Override
        public void add(E e) {
            size++;
            if(head==null) {
                head=new Node(e);
                tail=head;
            }
            else {
                tail.nn=new Node(e);
                tail=tail.nn;
            }
        }
    @Override
        public boolean remove(E e) {
            if(e==head.data) {
                head=head.nn;
                size--;
                return true;
            }
            Node temp=head;
            while(temp.nn!=null) {
                if(e==temp.nn.data) {
                    temp.nn=temp.nn.nn;
                    size--;
                    return true;
                }
                temp=temp.nn;
            }
            return false;
        }
    @Override
        public E get(int index) {
            Node temp=head;
            while(index!=0) {
                temp=temp.nn;
                index--;
            }
            return temp.data;
        }
    @Override
        public boolean contains(E e) {
            Node temp = head;
            while( temp != null ) {
                if(temp.data == e) return true;
                temp = temp.nn;
            }
            return false;
        }
    @Override
        public int size() { return size; }
    @Override
        public void clear() {
            head = null;
            size = 0;
        }
    @Override
        public boolean isEmpty() {
            if(size==0) return true;
            return false;
        }
    @Override
        public Iterator<E> iterator() {
            return new Iterator<E>() {
                private Node t=head;
                public boolean hasNext() {
                    return t!=null;
                }
                public E next() {
                    E e=t.data;
                    t=t.nn;
                    return e;
                }
            };
        }
}
